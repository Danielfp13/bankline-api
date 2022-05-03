package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CorrentistaService {

    private CorrentistaRepository repository;

    public Correntista save(CorrentistaDTO obj) {
        Correntista correntista = new Correntista();
        BeanUtils.copyProperties(obj, correntista);

        Conta conta = new Conta(new Date().getTime(), 0.0);
        correntista.setConta(conta);
        return repository.save(correntista);
    }
}
