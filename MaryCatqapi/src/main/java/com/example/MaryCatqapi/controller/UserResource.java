package com.example.MaryCatqapi.controller;


import com.example.MaryCatqapi.dto.UserAddress.UserAddressPutDTO;
import com.example.MaryCatqapi.dto.UserDTO.UserPostDTO;
import com.example.MaryCatqapi.dto.UserDTO.UserPutDTO;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserService service;
    Logger log = LoggerFactory.getLogger(UserResource.class);

    public UserResource(UserService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<UserPostDTO>> usersByPage(Pageable pageable){
        return ResponseEntity.ok(service.usersByPage(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserPostDTO> userById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(service.userById(Long.parseLong(id)));
    }


    @GetMapping("/find")
    public ResponseEntity<UserPostDTO> usersByEmail(@RequestParam(required = false)String email){
        return ResponseEntity.ok(service.userByEmail(email));
    }

    @GetMapping("/findList")
    public ResponseEntity<Page<UserPostDTO>>usersByName(@RequestParam (required = false)String name,
                                                        @RequestParam(required = false)String email,
                                                        @RequestParam(required = false)String address,
                                                        @RequestParam(required = false)String beginDate,
                                                        @RequestParam(required = false)String endDate,
                                                        Pageable pageable){
        return ResponseEntity.ok(service.userBySearch(name, email,address,beginDate, endDate,pageable));
    }

    @PostMapping
    public ResponseEntity<UserPostDTO> saveUser(@RequestBody @Valid UserPostDTO userPostDto){

        return new ResponseEntity<>(service.save(userPostDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) throws EntityNotFoundException{
        service.delete(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateUser(@RequestBody @Valid UserPutDTO userPutDTO                                                 )
            throws EntityNotFoundException{
        service.update(userPutDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
