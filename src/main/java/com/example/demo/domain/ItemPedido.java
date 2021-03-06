package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	/**
	 * 
	 */
	public ItemPedido() {
		super();
	}

	/**
	 * @param pedido
	 * @param produto
	 * @param desconto
	 * @param quantidade
	 * @param preco
	 */
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	/**
	 * @return the id
	 */
	public ItemPedidoPK getId() {
		return id;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return this.id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	@JsonIgnore
	public Produto getProduto() {
		return this.id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	/**
	 * @return the desconto
	 */
	public Double getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto
	 *            the desconto to set
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public double getSubTotal() {
		return (preco - desconto) * quantidade;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
