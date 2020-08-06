package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.CantidadErrorException;

public class Cantidad 
{
	private final int cantidad;
	
	public Cantidad(int cantidad)
	{
		this.cantidad = cantidad;
		if(cantidad<1)
			throw new CantidadErrorException();
	}

	public int getCantidad() { return cantidad; }
}
