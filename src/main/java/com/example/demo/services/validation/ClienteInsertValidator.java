package com.example.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.dto.ClienteNewDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.resources.exception.FieldMessage;
import com.example.demo.services.validation.util.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<FieldMessage>();

		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getIdentificacao())) {
			list.add(new FieldMessage("identificacao", "CPF inválido"));
		} else if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !BR.isValidCNPJ((objDto.getIdentificacao()))) {
			list.add(new FieldMessage("identificacao", "CNPJ inválido"));
		}

		if (clienteRepository.findByEmail(objDto.getEmail()) != null) {
			list.add(new FieldMessage("email", "Email já existe."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
