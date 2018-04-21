package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.domain.Categoria;

public class CategoriaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {

	}
	public CategoriaDTO(Categoria categoria) {
		setId(categoria.getId());
		setNome(categoria.getNome());
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

}