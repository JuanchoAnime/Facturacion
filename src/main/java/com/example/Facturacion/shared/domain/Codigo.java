package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.ValueErrorException;

public class Codigo 
{
	private final String codigo;
	
	public Codigo(String codigo) 
	{
		try {
			this.codigo = codigo;
			if (codigo.length() < 5 || codigo.length() > 33) 
				throw new ValueErrorException();
		} catch (Exception e) {
			throw new ValueErrorException();
		}
	}

	public String getCodigo() { 
		return codigo; 
	}
}
