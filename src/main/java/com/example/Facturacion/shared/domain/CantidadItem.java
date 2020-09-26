package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class CantidadItem 
{
	private final int value;
	
	public CantidadItem(int cantidad)
	{
		this.value = cantidad;
		if(cantidad<1)
			Util.INSTANCE.throwException("exception.cantidadItemError", Integer.toString(cantidad));
	}

	public int getValue() { return value; }
}
