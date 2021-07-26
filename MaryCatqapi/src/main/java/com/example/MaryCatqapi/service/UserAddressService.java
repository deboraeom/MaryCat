package com.example.MaryCatqapi.service;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.UserAddressMapper.UserAddressPostMapper;
import com.example.MaryCatqapi.repository.UserAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAddressService {
    private final UserAddressRepository userAddressRepository;
    final UserAddressPostMapper userAddressPostMapper = UserAddressPostMapper.INSTANCE;
    Logger log = LoggerFactory.getLogger(UserAddressService.class);

    public UserAddressService( final UserAddressRepository userAddressRepository){
        this.userAddressRepository=userAddressRepository;
    }

    public Page<UserAddressPostDTO> userAddressByPage(Pageable pageable){
        return userAddressRepository.findAll(pageable)
                .map(userAddressPostMapper::toDto);
    }

    @Transactional
    public UserAddressPostDTO save(UserAddressPostDTO userAddressPostDTO) throws EntityNotFoundException {
        UserAddress userAddress = userAddressPostMapper.toModel(userAddressPostDTO);
        userAddress.setId(null);
        return (userAddressPostMapper.toDto(userAddressRepository.save(userAddress)));
    }

    public void deleteUserAddress(Long id) throws EntityNotFoundException{
        System.out.println("entrou aqui"+ id);
        userAddressRepository.delete(userAddressRepository.getById(id));
    }
}
