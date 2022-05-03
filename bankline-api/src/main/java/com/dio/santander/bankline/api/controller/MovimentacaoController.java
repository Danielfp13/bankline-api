package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
@AllArgsConstructor
public class MovimentacaoController {

    private MovimentacaoRepository repository;

    private MovimentacaoService movimentacaoService;

    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Movimentacao> save(@RequestBody MovimentacaoDTO movimentacaoDTO) {
        Movimentacao movimentacao = movimentacaoService.save(movimentacaoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movimentacao.getId()).toUri();
        return ResponseEntity.created(uri).body(movimentacao);
    }

}
