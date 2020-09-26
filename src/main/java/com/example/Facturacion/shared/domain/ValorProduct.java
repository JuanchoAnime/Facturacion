package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class ValorProduct 
{
	private final Double value;

	public ValorProduct(Double valor) {
	this.value = valor;
	if(valor<1)
		Util.INSTANCE.throwException("exception.valueProductError", Double.toString(valor));
	if(valor>9999999.0)
		Util.INSTANCE.throwException("exception.valueProductError", Double.toString(valor));
	}


	public Double getValue() {
		return value;
	}
}
