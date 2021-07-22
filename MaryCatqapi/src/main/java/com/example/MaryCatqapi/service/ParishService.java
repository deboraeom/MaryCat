package com.example.MaryCatqapi.service;



import com.example.MaryCatqapi.dto.ParishesDTO.ParishDTO;
import com.example.MaryCatqapi.entity.Parish;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.mapper.ParishesMapper.ParishMapper;
import com.example.MaryCatqapi.repository.ParishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParishService {

    private final ParishRepository parishRepository;
    final ParishMapper parishMapper = ParishMapper.INSTANCE;
    Logger log = LoggerFactory.getLogger(ParishService.class);

    public ParishService(final ParishRepository parishRepository) {
        this.parishRepository = parishRepository;
    }

    public Page<ParishDTO> parishesByPage(Pageable pageable) {
        return parishRepository.findAll(pageable)
                .map(parishMapper::toDto);
    }

    public ParishDTO parishById(Long id) throws EntityNotFoundException {
        return parishMapper.toDto(verifyIfExist(id));
    }


    public Parish verifyIfExist(Long id) throws EntityNotFoundException {
        return parishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paróquia não encontrada"));
    }

    @Transactional
    public ParishDTO save(ParishDTO parishdto) {
        Parish parish = parishMapper.toModel(parishdto);
        parish.setId(null);
        return (parishMapper.toDto(parishRepository.save(parish)));
    }

    public void delete(Long id) throws EntityNotFoundException {
        parishRepository.delete(verifyIfExist(id));
    }

    public ParishDTO update(ParishDTO parishDTO) throws EntityNotFoundException {
        Parish savedParish = verifyIfExist(parishDTO.getId());
        return parishMapper.toDto(parishRepository.save(parishMapper.toModel(parishDTO)));
    }


    public Page parishByName(String name, Pageable pageable) {
        String cnpj= name;
        return parishRepository.findByName(name,cnpj,pageable).map(parishMapper::toDto);
    }
}