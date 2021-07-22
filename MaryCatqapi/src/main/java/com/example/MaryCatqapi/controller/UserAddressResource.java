package com.example.MaryCatqapi.controller;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressDTO;
import com.example.MaryCatqapi.dto.UserDTO;
import com.example.MaryCatqapi.service.UserAddressService;
import com.example.MaryCatqapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usersAddress")
public class UserAddressResource {
    private final UserAddressService service;
    Logger log = LoggerFactory.getLogger(UserAddressResource.class);

    public UserAddressResource(UserAddressService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<UserAddressDTO>> usersByPage(Pageable pageable){
        return ResponseEntity.ok(service.userAddressByPage(pageable));
    }
}
