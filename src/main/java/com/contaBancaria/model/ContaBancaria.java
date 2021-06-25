package com.contaBancaria.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "conta_bancaria_id_seq", sequenceName = "conta_bancaria_id_seq", allocationSize = 1)
public class ContaBancaria {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_bancaria_id_seq")
    private Long id;

    private String nome;

    private Integer numeroConta;

    private Integer agencia;

    private Boolean chequeEspecialLiberado;

    private Double saldo;

    private Double chequeEspecial;

    private Double taxa;

}
