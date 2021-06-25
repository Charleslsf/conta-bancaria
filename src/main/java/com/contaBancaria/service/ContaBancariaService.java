package com.contaBancaria.service;

import com.contaBancaria.dto.ContaBancariaDTO;
import com.contaBancaria.exception.ResourceNotFoundException;
import com.contaBancaria.form.ContaBancariaForm;
import com.contaBancaria.model.ContaBancaria;
import com.contaBancaria.repository.ContaBancariaRepository;
import com.contaBancaria.repository.filter.ContaBancariaFilter;
import com.contaBancaria.repository.spec.ContaBancariaSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContaBancariaService {

    private final ContaBancariaRepository repository;

    public Page<ContaBancaria> findByFilter(ContaBancariaFilter filter, Pageable pageable) {
        return repository.findAll(ContaBancariaSpec.withFilter(filter), pageable);
    }

    public void update(Long id, ContaBancariaForm contaBancariaForm) {
        ContaBancaria contaBancaria = getContaBancariaById(id);
        contaBancariaForm.copyToModel(contaBancaria);
        repository.save(contaBancaria);
    }

    public ContaBancariaDTO save(ContaBancariaForm contaBancariaForm) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancariaForm.copyToModel(contaBancaria);
        return ContaBancariaDTO.toDTO(repository.save(contaBancaria));
    }

    public void delete(Long id) {
        getContaBancariaById(id);
        repository.deleteById(id);
    }

    private ContaBancaria getContaBancariaById(Long id) {
        Optional<ContaBancaria> contaBancariaOptional = repository.findById(id);
        return contaBancariaOptional.orElseThrow(() -> new ResourceNotFoundException("Conta Bancaria não encontrada."));
    }


}
