package com.example.MaryCatqapi.controller;


import com.example.MaryCatqapi.dto.UserAddress.UserAddressDTO;
import com.example.MaryCatqapi.dto.UserDTO;
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
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserService service;
    Logger log = LoggerFactory.getLogger(UserResource.class);

    public UserResource(UserService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> usersByPage(Pageable pageable){
        return ResponseEntity.ok(service.usersByPage(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> userById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(service.userById(Long.parseLong(id)));
    }


    @GetMapping("/find")
    public ResponseEntity<UserDTO> usersByEmail(@RequestParam(required = false)String email){
        return ResponseEntity.ok(service.userByEmail(email));
    }

    @GetMapping("/findList")
    public ResponseEntity<Page<UserDTO>>usersByName(@RequestParam (required = false)String name,
                                                    @RequestParam(required = false)String email,
                                                    @RequestParam(required = false)String address,
                                                    @RequestParam(required = false)String beginDate,
                                                    @RequestParam(required = false)String endDate,
                                                    Pageable pageable){
        return ResponseEntity.ok(service.userBySearch(name, email,address,beginDate, endDate,pageable));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDto){

        return new ResponseEntity<>(service.save(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) throws EntityNotFoundException{
        service.delete(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateUser(@RequestBody @Valid UserDTO userDTO)
            throws EntityNotFoundException{
        service.update(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
