package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> result = repo.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
