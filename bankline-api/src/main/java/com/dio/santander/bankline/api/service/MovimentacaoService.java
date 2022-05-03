package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.model.unums.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovimentacaoService {

    private MovimentacaoRepository repository;

    private CorrentistaRepository correntistaRepository;

    public Movimentacao save(MovimentacaoDTO obj) {
        Movimentacao movimentacao = new Movimentacao();
        Double valor = obj.getTipo() == MovimentacaoTipo.RECEITA ? obj.getValor() : obj.getValor() * -1;
        BeanUtils.copyProperties(obj, movimentacao);
        obj.setValor(valor);
        movimentacao.setDataHora(LocalDateTime.now());
        Optional<Correntista> correntista = correntistaRepository.findById(obj.getIdConta());
       if(correntista.isPresent()){
           correntista.get().getConta().setSaldo(correntista.get().getConta().getSaldo() + valor);
           correntistaRepository.save(correntista.get());
       }
        return repository.save(movimentacao);
    }
}
