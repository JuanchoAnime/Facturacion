package com.example.Facturacion.infrastructure.exception;

public class InvalidateNameException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public InvalidateNameException() {
		super("El nombre no es valido");
	}
}
