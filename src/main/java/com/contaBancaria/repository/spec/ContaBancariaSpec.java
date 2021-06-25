package com.contaBancaria.repository.spec;

import com.contaBancaria.model.ContaBancaria;
import com.contaBancaria.repository.filter.ContaBancariaFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContaBancariaSpec {

	public static Specification<ContaBancaria> withFilter(ContaBancariaFilter filter) {
		return (root, query, builder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(filter.getNome())) {
				predicates.add(builder.like(builder.upper(root.get("nome")),  "%" + filter.getNome().toUpperCase() + "%"));
			}

			if (Objects.nonNull(filter.getAgencia())) {
				predicates.add(builder.equal(root.get("agencia"),  filter.getAgencia()));
			}
			
			if (Objects.nonNull(filter.getChequeEspecialLiberado())) {
				predicates.add(builder.equal(root.get("chequeEspecialLiberado"), filter.getChequeEspecialLiberado()));
			}

			query.orderBy(builder.desc(root.get("nome")));
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	
}
