package com.example.demo.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	/**
	 * @param cod
	 * @param descricao
	 */
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	/**
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		TipoCliente result = null;
		if (cod != null) {
			for (TipoCliente item : TipoCliente.values()) {
				if (cod.equals(item.getCod())) {
					result = item;
					break;
				}
			}
		}

		return result;
	}
}
