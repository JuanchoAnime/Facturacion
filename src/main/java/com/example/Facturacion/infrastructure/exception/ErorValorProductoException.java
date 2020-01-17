package com.example.Facturacion.infrastructure.exception;

public class ErorValorProductoException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public ErorValorProductoException() {
		super("Valor erroneo");
	}
}
