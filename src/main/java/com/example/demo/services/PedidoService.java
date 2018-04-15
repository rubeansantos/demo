package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pedido;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	public PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> result = repo.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
