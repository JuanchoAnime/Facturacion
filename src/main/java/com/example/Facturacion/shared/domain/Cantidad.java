package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.CantidadErrorException;

public class Cantidad 
{
	private final int value;
	
	public Cantidad(int cantidad)
	{
		this.value = cantidad;
		if(cantidad<1)
			throw new CantidadErrorException();
	}

	public int getValue() { return value; }
}
