package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class ValorItem {
	private final Double value;
	
	public ValorItem(Double valor) {
		this.value = valor;
		if(valor<1)
			Util.INSTANCE.throwException("exception.valueItemError", Double.toString(valor));
		if(valor>99999999999.0)
			Util.INSTANCE.throwException("exception.valueItemError", Double.toString(valor));
	}

	public Double getValue() {
		return value;
	}
}