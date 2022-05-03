package com.dio.santander.bankline.api.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private Long numero;

    @Column(name = "conta_saldo")
    private Double saldo;

}
