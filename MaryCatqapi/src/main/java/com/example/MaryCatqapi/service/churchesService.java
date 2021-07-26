package com.example.MaryCatqapi.service;

import com.example.MaryCatqapi.dto.ChurchAddressDTO.ChurchAddressPostDTO;
import com.example.MaryCatqapi.dto.ChurchDTO;
import com.example.MaryCatqapi.entity.Church;
import com.example.MaryCatqapi.entity.ChurchAddress;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.ChurchAddressMapper.ChurchAddressPostMapper;
import com.example.MaryCatqapi.mapper.ChurchMapper;
import com.example.MaryCatqapi.repository.ChurchAddressRepository;
import com.example.MaryCatqapi.repository.churchesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.isNull;

@Service
public class churchesService {


    private final churchesRepository churchesRepository;
    private final ChurchAddressRepository churchAddressRepository;
    final ChurchMapper churchMapper= ChurchMapper.INSTANCE;
    final ChurchAddressPostMapper churchAddressPostMapper = ChurchAddressPostMapper.INSTANCE;

    Logger log = LoggerFactory.getLogger(churchesService.class);

    public churchesService(final churchesRepository churchesRepository, ChurchAddressRepository churchAddressRepository){
        this.churchesRepository=churchesRepository;
        this.churchAddressRepository = churchAddressRepository;
    }

    public Page<ChurchDTO> churchesByPage(Pageable pageable){
          return churchesRepository.findAll(pageable)
                  .map(churchMapper::toDto);
      }
      public ChurchDTO churchById(Long id) throws EntityNotFoundException{
        return churchMapper.toDto(verifyIfExistChurch(id));
      }

    public ChurchDTO churchByEmail(String email){
        return churchMapper.toDto(churchesRepository.findByEmail(email));
    }

    public Page<ChurchDTO> churchByName(String name, Pageable pageable){
        return churchesRepository.findByName(name,pageable).map(churchMapper::toDto);

    }

    @Transactional
    public ChurchDTO save(ChurchDTO churchDTO) throws EntityNotFoundException{

        ChurchAddressPostDTO churchAddressPostDTO=churchDTO.getAddress();

        if(!isNull(churchAddressPostDTO)){
            churchDTO.setAddress(saveChurchAddress(churchAddressPostDTO));}

           Church church = churchMapper.toModel(churchDTO);
           church.setId(null);
           return (churchMapper.toDto(churchesRepository.save(church)));
      }

  @Transactional
    public ChurchAddressPostDTO saveChurchAddress(ChurchAddressPostDTO churchAddressPostDTO)
          throws EntityNotFoundException {
        ChurchAddress churchAddress = churchAddressPostMapper.toModel(churchAddressPostDTO);
        churchAddress.setId(null);
        return (churchAddressPostMapper.toDto(churchAddressRepository.save(churchAddress)));
    }

    public void delete(Long id) throws EntityNotFoundException{
       Church church= verifyIfExistChurch(id);
       ChurchAddress churchAddress=church.getAddress();
        if(!isNull(churchAddress) )deleteChurchAddress(churchAddress.getId());
        churchesRepository.delete(church);
      }

    public void deleteChurchAddress(Long id) throws EntityNotFoundException{
        churchAddressRepository.delete(verifyIfExistUserAddress(id));
    }

    public ChurchDTO update(ChurchDTO churchDTO) throws EntityNotFoundException{
        verifyIfExistChurch(churchDTO.getId());
        updateOrDeleteChurchAddress(churchDTO);
         return churchMapper.toDto(churchesRepository.save(churchMapper.toModel(churchDTO)));
    }

  public void updateOrDeleteChurchAddress(ChurchDTO churchDTO){
        ChurchAddress churchAddressIdFromData;
        churchAddressIdFromData = verifyIfExistChurch(churchDTO.getId()).getAddress();
        if(!isNull(churchAddressIdFromData)){
            ChurchAddressPostDTO ChurchAddressIdFromParam = churchDTO.getAddress();
            if(isNull(churchAddressIdFromData)) deleteChurchAddress(churchAddressIdFromData.getId());
            else churchDTO.getAddress().setId(churchAddressIdFromData.getId());
        }}



    public Church verifyIfExistChurch(Long id) throws EntityNotFoundException {
        return churchesRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Igreja não encontrada"));
    }

    private ChurchAddress verifyIfExistUserAddress(Long id) throws EntityNotFoundException {
        return churchAddressRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Endereço inválido"));
    }

}








