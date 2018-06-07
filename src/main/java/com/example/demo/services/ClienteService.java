package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.ClienteInsertDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.services.exceptions.DataIntegrityException;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;

	@Autowired
	public EnderecoRepository enderecoRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> result = clienteRepository.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	/*************************************************************************/
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = clienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	/*************************************************************************/
	public Cliente update(Cliente obj) {
		Cliente newobj = find(obj.getId());
		updateData(newobj, obj);
		return clienteRepository.save(newobj);
	}

	/*************************************************************************/
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	/*************************************************************************/
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public Cliente fromDTO(ClienteInsertDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getIdentificacao(),
				TipoCliente.toEnum(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);

		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null && !objDto.getTelefone2().isEmpty()) {
			cli.getTelefones().add(objDto.getTelefone2());
		}

		if (objDto.getTelefone3() != null && !objDto.getTelefone3().isEmpty()) {
			cli.getTelefones().add(objDto.getTelefone3());
		}

		return cli;

	}

	/*************************************************************************/
	private void updateData(Cliente newobj, Cliente obj) {
		newobj.setNome(obj.getNome());
		newobj.setEmail(obj.getEmail());
	}
}
