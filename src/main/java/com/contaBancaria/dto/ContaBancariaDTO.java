package com.contaBancaria.dto;

import com.contaBancaria.model.ContaBancaria;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ContaBancariaDTO {

    private Long id;

    private String nome;

    private Integer numeroConta;

    private Integer agencia;

    private Boolean chequeEspecialLiberado;

    private Double saldo;

    private Double chequeEspecial;

    private Double taxa;

    public static ContaBancariaDTO create(ContaBancaria contaBancaria) {
        return new ModelMapper().map(contaBancaria, ContaBancariaDTO.class);
    }
}
