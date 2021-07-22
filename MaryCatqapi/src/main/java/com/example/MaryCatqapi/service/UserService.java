package com.example.MaryCatqapi.service;


import com.example.MaryCatqapi.dto.UserDTO;
import com.example.MaryCatqapi.entity.User;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.UserMapper;
import com.example.MaryCatqapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
   // private final UserService userService;
    private final UserRepository usersRepository;
    final UserMapper userMapper= UserMapper.INSTANCE;
    Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService( final UserRepository usersRepository){

        this.usersRepository=usersRepository;
    }

    public Page<UserDTO> usersByPage(Pageable pageable){
        return usersRepository.findAll(pageable)
                .map(userMapper::toDto);
    }
    public UserDTO userById(Long id) throws EntityNotFoundException{
        return userMapper.toDto(verifyIfExist(id));
    }


    public User verifyIfExist(Long id) throws EntityNotFoundException {
         return usersRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Igreja não encontrada"));
    }

    @Transactional
    public UserDTO save(UserDTO userDTO) throws EntityNotFoundException {
        User user = userMapper.toModel(userDTO);
        user.setId(null);
        return (userMapper.toDto(usersRepository.save(user)));
    }

    public void delete(Long id) throws EntityNotFoundException{
        usersRepository.delete(verifyIfExist(id));
    }

    public UserDTO update(UserDTO userDTO) throws EntityNotFoundException{
        verifyIfExist(userDTO.getId());
        return userMapper.toDto(usersRepository.save(userMapper.toModel(userDTO)));
    }

    public UserDTO userByEmail(String email){
        return userMapper.toDto(usersRepository.findByEmail(email));
    }


    public Page<UserDTO> userBySearch(String name, String email, String address, String beginDate,
                                      String endDate, Pageable pageable){
        return usersRepository.findBySearch(name,email, address, beginDate,endDate, pageable).map(userMapper::toDto);

    }



}
