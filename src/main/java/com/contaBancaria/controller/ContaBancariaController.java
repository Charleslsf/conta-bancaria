package com.contaBancaria.controller;

import com.contaBancaria.dto.ContaBancariaDTO;
import com.contaBancaria.dto.ContaBancariaDetalheDTO;
import com.contaBancaria.form.ContaBancariaForm;
import com.contaBancaria.repository.filter.ContaBancariaFilter;
import com.contaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

	@Autowired
	private ContaBancariaService contaBancariaService;

	@GetMapping(produces="application/json")
	public Page<ContaBancariaDTO> findByFilter(ContaBancariaFilter filtro, @PageableDefault() Pageable pageable) {
		return contaBancariaService.findByFilter(filtro, pageable).map(ContaBancariaDTO::create);
	}

	@GetMapping(path = "/detalhe", produces="application/json")
	public ContaBancariaDetalheDTO findByConta(Integer numeroConta) {
		return ContaBancariaDetalheDTO.toDTO(contaBancariaService.findByConta(numeroConta));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id,  @RequestBody @Valid ContaBancariaForm contaBancariaForm) {
		contaBancariaService.update(id, contaBancariaForm);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaBancariaDetalheDTO create(@RequestBody @Valid ContaBancariaForm contaBancariaForm) {
		return contaBancariaService.save(contaBancariaForm);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		contaBancariaService.delete(id);
	}
}
