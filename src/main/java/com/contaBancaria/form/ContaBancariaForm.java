package com.contaBancaria.form;

import com.contaBancaria.model.ContaBancaria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter @Setter
public class ContaBancariaForm implements Serializable {

    @NotBlank
    private String nome;

    @NotNull
    private Integer numeroConta;

    @NotNull
    private Integer agencia;

    @NotNull
    private Boolean chequeEspecialLiberado;

    @NotNull
    private Double saldo;

    @NotNull
    private Double chequeEspecial;

    @NotNull
    private Double taxa;


    public void copyToModel(ContaBancaria contaBancaria) {
        contaBancaria.setNome(nome);
        contaBancaria.setNumeroConta(numeroConta);
        contaBancaria.setAgencia(agencia);
        contaBancaria.setChequeEspecialLiberado(chequeEspecialLiberado);
        contaBancaria.setSaldo(saldo);
        contaBancaria.setChequeEspecial(chequeEspecial);
        contaBancaria.setTaxa(taxa);
    }

}
