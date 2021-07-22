package com.example.MaryCatqapi.controller;

import com.example.MaryCatqapi.dto.ChurchDTO;
import com.example.MaryCatqapi.dto.ParishesDTO.ParishDTO;
import com.example.MaryCatqapi.dto.ParishesDTO.ParishesChurchValidationDTO;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.service.churchesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/churches")
public class churchesResource {

    private final churchesService service;
    Logger log = LoggerFactory.getLogger(churchesResource.class);

    public churchesResource(churchesService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<ChurchDTO>> churchesByPage(Pageable pageable){
        return ResponseEntity.ok(service.churchesByPage(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ChurchDTO> churchById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(service.churchById(Long.parseLong(id)));
    }
    @GetMapping("/find")
    public ResponseEntity<ChurchDTO> churchesByEmail(@RequestParam (required = false)String email){
        return ResponseEntity.ok(service.churchByEmail(email));
    }

    @GetMapping("/findList")
    public ResponseEntity<Page<ChurchDTO>>churchesByName(@RequestParam (required = false)String name,Pageable pageable){
        return ResponseEntity.ok(service.churchByName(name, pageable));
    }


    @PostMapping
    public ResponseEntity<ChurchDTO> saveChurch(@RequestBody @Valid ChurchDTO churchDto,
                                                @Valid ParishesChurchValidationDTO parishDTO){
        return new ResponseEntity<>(service.save(churchDto),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteChurch(@PathVariable String id) throws EntityNotFoundException{
        service.delete(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<HttpStatus> updataChurch(@RequestBody @Valid ChurchDTO churchDTO,
                                                   @Valid ParishesChurchValidationDTO parishDTO)
            throws EntityNotFoundException{
        service.update(churchDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
