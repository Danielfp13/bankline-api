package com.dio.santander.bankline.api.model;

import com.dio.santander.bankline.api.model.unums.MovimentacaoTipo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;


}
