package com.paulomdsbh.avanco.entidades.enums;

public enum StatusPedido {
	AGUARDANDO_PAGAMENTO(1),
	FATURADO(2);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
			return codigo;
	}
	
	public static StatusPedido valueOf(int codigo) {
		for (StatusPedido value: StatusPedido.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("StatusPedido Inválido");
	}
}
