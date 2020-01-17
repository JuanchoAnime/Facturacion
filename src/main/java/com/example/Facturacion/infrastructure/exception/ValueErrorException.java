package com.example.Facturacion.infrastructure.exception;

public class ValueErrorException extends RuntimeException 
{	
	private static final long serialVersionUID = 1L;

	public ValueErrorException() 
	{ 
		super("Los Caracteres no son validos");
	}
}
