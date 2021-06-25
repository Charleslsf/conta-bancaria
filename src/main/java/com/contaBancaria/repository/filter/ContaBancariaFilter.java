package com.contaBancaria.repository.filter;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContaBancariaFilter {

    private String nome;

    private Integer agencia;

    private Boolean chequeEspecialLiberado;

}
