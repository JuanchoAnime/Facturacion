package com.example.Facturacion.infrastructure.exception;

public class CantidadErrorException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public CantidadErrorException() {
		super("La cantidad no puede ser 0");
	}

}
