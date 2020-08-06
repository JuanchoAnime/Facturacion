package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.ValueErrorException;

public class Codigo 
{
	private final String value;
	
	public Codigo(String codigo) 
	{
		try {
			this.value = codigo;
			if (codigo.length() < 5 || codigo.length() > 33) 
				throw new ValueErrorException();
		} catch (Exception e) {
			throw new ValueErrorException();
		}
	}

	public String getValue() { 
		return value; 
	}
}
