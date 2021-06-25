package com.contaBancaria.dto;

import com.contaBancaria.model.ContaBancaria;
import com.contaBancaria.util.Util;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class ContaBancariaDTO implements Serializable {

    private String nome;

    private String ContaAgencia;

    private String chequeEspecialLiberado;

    private String saldo;

    private String chequeEspecialCorrente;

    private String chequeEspecialComJuros;

    public static ContaBancariaDTO toDTO(ContaBancaria contaBancaria) {
        ContaBancariaDTO dto = new ContaBancariaDTO();
        dto.setNome(contaBancaria.getNome());
        dto.setContaAgencia(getContaAgencia(contaBancaria));
        dto.setChequeEspecialLiberado(getChequeEspecialLiberado(contaBancaria));
        dto.setSaldo(Util.converterLocalCurrency(contaBancaria.getSaldo()));
        dto.setChequeEspecialCorrente(Util.converterLocalCurrency(contaBancaria.getChequeEspecial()));
        dto.setChequeEspecialComJuros(getChequeEspecialComJuros(contaBancaria));
        return dto;
    }

    private static String getChequeEspecialComJuros(ContaBancaria contaBancaria) {
        return Util.converterLocalCurrency(((contaBancaria.getTaxa() + 100) / 100) * contaBancaria.getChequeEspecial());
    }

    private static String getContaAgencia(ContaBancaria contaBancaria) {
        return contaBancaria.getNumeroConta() + " / " + contaBancaria.getAgencia();
    }

    private static String getChequeEspecialLiberado(ContaBancaria contaBancaria) {
        return contaBancaria.getChequeEspecialLiberado() ? "Liberado" : "Não Liberado";
    }

}
