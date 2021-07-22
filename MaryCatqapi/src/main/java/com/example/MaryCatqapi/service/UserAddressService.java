package com.example.MaryCatqapi.service;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressDTO;
import com.example.MaryCatqapi.dto.UserDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import com.example.MaryCatqapi.mapper.UserAddressMapper.UserAddressMapper;
import com.example.MaryCatqapi.repository.UserAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {
    private final UserAddressRepository userAddressRepository;
    final UserAddressMapper userAddressMapper= UserAddressMapper.INSTANCE;

    Logger log = LoggerFactory.getLogger(UserAddressService.class);

    public UserAddressService( final UserAddressRepository userAddressRepository){

        this.userAddressRepository=userAddressRepository;
    }
    public Page<UserAddressDTO> userAddressByPage(Pageable pageable){
        return userAddressRepository.findAll(pageable)
                .map(userAddressMapper::toDto);
    }

}
