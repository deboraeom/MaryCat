package com.example.MaryCatqapi.service;

import com.example.MaryCatqapi.dto.ChurchDTO;
import com.example.MaryCatqapi.entity.Church;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.ChurchMapper;
import com.example.MaryCatqapi.repository.churchesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class churchesService {

    private final ParishService parishService;
    private final churchesRepository churchesRepository;
    final ChurchMapper churchMapper= ChurchMapper.INSTANCE;
    Logger log = LoggerFactory.getLogger(churchesService.class);

    public churchesService(ParishService parishService, final churchesRepository churchesRepository){
        this.parishService = parishService;
        this.churchesRepository=churchesRepository;
      }

    public Page<ChurchDTO> churchesByPage(Pageable pageable){
          return churchesRepository.findAll(pageable)
                  .map(churchMapper::toDto);
      }
      public ChurchDTO churchById(Long id) throws EntityNotFoundException{
        return churchMapper.toDto(verifyIfExist(id));
      }


    public Church verifyIfExist(Long id) throws EntityNotFoundException {
        return churchesRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Igreja não encontrada"));
    }

    @Transactional
    public ChurchDTO save(ChurchDTO churchDTO) throws EntityNotFoundException{
           Church church = churchMapper.toModel(churchDTO);
           church.setId(null);
           return (churchMapper.toDto(churchesRepository.save(church)));
      }

    public void delete(Long id) throws EntityNotFoundException{
        churchesRepository.delete(verifyIfExist(id));
      }

    public ChurchDTO update(ChurchDTO churchDTO) throws EntityNotFoundException{
        verifyIfExist(churchDTO.getId());
         return churchMapper.toDto(churchesRepository.save(churchMapper.toModel(churchDTO)));
    }

    public ChurchDTO churchByEmail(String email){
        return churchMapper.toDto(churchesRepository.findByEmail(email));
    }

    public Page<ChurchDTO> churchByName(String name, Pageable pageable){
        return churchesRepository.findByName(name,pageable).map(churchMapper::toDto);

    }
}








