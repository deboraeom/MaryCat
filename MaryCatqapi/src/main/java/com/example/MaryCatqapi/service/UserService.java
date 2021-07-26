package com.example.MaryCatqapi.service;


import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.dto.UserAddress.UserAddressPutDTO;
import com.example.MaryCatqapi.dto.UserDTO.UserPostDTO;
import com.example.MaryCatqapi.dto.UserDTO.UserPutDTO;
import com.example.MaryCatqapi.entity.User;
import com.example.MaryCatqapi.entity.UserAddress;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.UserAddressMapper.UserAddressPostMapper;
import com.example.MaryCatqapi.mapper.UserPutMapper.UserPostMapper;
import com.example.MaryCatqapi.mapper.UserPutMapper.UserPutMapper;
import com.example.MaryCatqapi.repository.UserAddressRepository;
import com.example.MaryCatqapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.Objects.isNull;

@Service
public class UserService {
    private final UserRepository usersRepository;
    private final UserAddressRepository userAddressRepository;

    final UserPostMapper userMapper= UserPostMapper.INSTANCE;
    final UserPutMapper userPutMapper= UserPutMapper.INSTANCE;
    final UserAddressPostMapper userAddressPostMapper = UserAddressPostMapper.INSTANCE;

    Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(final UserRepository usersRepository, UserAddressRepository userAddressRepository){
        this.usersRepository=usersRepository;
        this.userAddressRepository = userAddressRepository;
    }

    public Page<UserPostDTO> usersByPage(Pageable pageable){
        return usersRepository.findAll(pageable)
                .map(userMapper::toDto);
    }
    public UserPostDTO userById(Long id) throws EntityNotFoundException{
        return userMapper.toDto(verifyIfExistUser(id));
    }

    public UserPostDTO userByEmail(String email){
        return userMapper.toDto(usersRepository.findByEmail(email));
    }


    public Page<UserPostDTO> userBySearch(String name, String email, String address, String beginDate,
                                          String endDate, Pageable pageable){
        return usersRepository.findBySearch(name,email, address, beginDate,endDate, pageable).map(userMapper::toDto);

    }


    @Transactional
    public UserPostDTO save(UserPostDTO userPostDTO) throws EntityNotFoundException {
        UserAddressPostDTO userAddressPostDTO =userPostDTO.getAddress();
        if(!isNull(userAddressPostDTO)){
            userPostDTO.getAddress().setId(saveUserAddress(userAddressPostDTO).getId());}
        User user = userMapper.toModel(userPostDTO);
        user.setId(null);
        return (userMapper.toDto(usersRepository.save(user)));
    }

    @Transactional
    public UserAddressPostDTO saveUserAddress(UserAddressPostDTO userAddressPostDTO) throws EntityNotFoundException {
        UserAddress userAddress = userAddressPostMapper.toModel(userAddressPostDTO);
        userAddress.setId(null);
        return (userAddressPostMapper.toDto(userAddressRepository.save(userAddress)));
    }

    @Transactional
    public void delete(Long id) throws EntityNotFoundException{
        User user =verifyIfExistUser(id);
        if(!isNull(user.getAddress()) )deleteUserAddress(user.getAddress().getId());
        usersRepository.delete(verifyIfExistUser(id));
    }

    public void deleteUserAddress(Long id) throws EntityNotFoundException{
         userAddressRepository.delete(verifyIfExistUserAddress(id));
    }

    @Transactional
    public UserPutDTO update(UserPutDTO userPutDTO) throws EntityNotFoundException{
        verifyIfExistUser(userPutDTO.getId());
        updateOrDeleteUserAddress(userPutDTO);
        return userPutMapper.toDto(usersRepository.save(userPutMapper.toModel(userPutDTO)));
    }

    public void updateOrDeleteUserAddress(UserPutDTO userPutDTO){
        UserAddress userAddressIdFromData;
        userAddressIdFromData =verifyIfExistUser(userPutDTO.getId()).getAddress();
        if(!isNull(userAddressIdFromData)){
            UserAddressPutDTO userAddressIdFromParam = userPutDTO.getAddress();
            if(isNull(userAddressIdFromParam)) deleteUserAddress(userAddressIdFromData.getId());
            else userPutDTO.getAddress().setId(userAddressIdFromData.getId());
        }
    }



    private User verifyIfExistUser(Long id) throws EntityNotFoundException {
        return usersRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Igreja não encontrada"));
    }

    private UserAddress verifyIfExistUserAddress(Long id) throws EntityNotFoundException {
        return userAddressRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Endereço inválido não encontrada"));
    }



}
