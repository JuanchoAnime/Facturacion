package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class Cantidad 
{
	private final int value;
	
	public Cantidad(int cantidad)
	{
		this.value = cantidad;
		if(cantidad<1)
			Util.INSTANCE.throwException("exception.cantidadItemError", Integer.toString(cantidad));
	}

	public int getValue() { return value; }
}
