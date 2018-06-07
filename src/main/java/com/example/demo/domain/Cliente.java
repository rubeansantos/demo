package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String identificacao;
	private Integer tipo;

	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param identificacao
	 * @param tipo
	 */
	public Cliente(Integer id, String nome, String email, String identificacao, TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.identificacao = identificacao;
		this.tipo = (tipo != null ? tipo.getCod() : null);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the identificacao
	 */
	public String getIdentificacao() {
		return identificacao;
	}

	/**
	 * @param identificacao
	 *            the identificacao to set
	 */
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	/**
	 * @return the tipo
	 */
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(this.tipo);
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * @param enderecos
	 *            the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * @return the telefones
	 */
	public Set<String> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones
	 *            the telefones to set
	 */
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos
	 *            the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
