package com.example.MaryCatqapi.controller;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.service.UserAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usersAddress")
public class UserAddressResource {
    private final UserAddressService service;
    Logger log = LoggerFactory.getLogger(UserAddressResource.class);

    public UserAddressResource(UserAddressService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<UserAddressPostDTO>> usersByPage(Pageable pageable){
        return ResponseEntity.ok(service.userAddressByPage(pageable));
    }

    @PostMapping
    public ResponseEntity<UserAddressPostDTO> saveUser(@RequestBody @Valid UserAddressPostDTO userAddressPostDto){

        return new ResponseEntity<>(service.save(userAddressPostDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) throws EntityNotFoundException {
        service.deleteUserAddress(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
