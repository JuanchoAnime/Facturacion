package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.ErorValorProductoException;;

public class Valor {
	private final Double value;
	
	public Valor(Double valor) {
		this.value = valor;
		if(valor<1)
			throw new ErorValorProductoException();
		if(valor>99999999999.0)
			throw new ErorValorProductoException();
	}

	public Double getValue() {
		return value;
	}
}
