package com.example.Facturacion.shared.domain;

import com.example.Facturacion.infrastructure.exception.InvalidateNameException;

public class Nombre {
	private final String name;
	
	public Nombre(String name) {
		try {
			this.name = name;
			if (name.length() < 0)
				throw new InvalidateNameException();
			if(!name.matches("[A-Z].*")) 
				throw new InvalidateNameException();
		} catch (Exception e) {
			throw new InvalidateNameException();
		}
	}

	public String getName() {
		return name;
	}
}
