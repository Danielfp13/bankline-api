package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/correntistas")
@AllArgsConstructor
public class CorrentistaController {

    private CorrentistaRepository repository;

    private CorrentistaService correntistaService;

    @GetMapping
    public ResponseEntity<List<Correntista>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Correntista> save(@RequestBody CorrentistaDTO correntistaDTO) {
        Correntista correntista = correntistaService.save(correntistaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(correntista.getId()).toUri();
        return ResponseEntity.created(uri).body(correntista);
    }

}
