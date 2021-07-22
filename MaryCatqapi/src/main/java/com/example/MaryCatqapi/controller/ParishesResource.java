package com.example.MaryCatqapi.controller;


import com.example.MaryCatqapi.dto.ParishesDTO.ParishDTO;
import com.example.MaryCatqapi.exception.EntityNotFoundException;
import com.example.MaryCatqapi.service.ParishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/parishes")
public class ParishesResource {

    private final ParishService service;
    Logger log = LoggerFactory.getLogger(ParishesResource.class);

    public ParishesResource(ParishService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<Page<ParishDTO>> parishesByPage(Pageable pageable){
        return ResponseEntity.ok(service.parishesByPage(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ParishDTO> parishById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(service.parishById(Long.parseLong(id)));
    }

    @GetMapping("/findList")
    public ResponseEntity<Page<ParishDTO>> parishByName(@RequestParam(required = false)String search, Pageable pageable){
        return ResponseEntity.ok(service.parishByName(search, pageable));
    }


    @PostMapping
    public ResponseEntity<ParishDTO> saveParish(@RequestBody @Valid ParishDTO parishDto){
        return new ResponseEntity<>(service.save(parishDto),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteParish(@PathVariable String id) throws EntityNotFoundException{
        service.delete(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<HttpStatus> updataParish(@RequestBody @Valid ParishDTO parishDTO) throws EntityNotFoundException{
        service.update(parishDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}




