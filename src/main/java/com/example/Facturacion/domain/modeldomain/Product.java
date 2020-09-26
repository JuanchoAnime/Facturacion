package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.NameProduct;
import com.example.Facturacion.shared.domain.ValueProduct;

public class Product 
{
	private final Codigo codigo;
	private final NameProduct nombre;
	private final ValueProduct valor;
	
	private Product(Codigo codigo, NameProduct nombre, ValueProduct valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public static Product of(Codigo codigo, NameProduct nombre, ValueProduct valor) {
		return new Product(codigo, nombre, valor);
	}

	public Codigo getCodigo() { 
		return codigo; 
	}
	public NameProduct getNombre() { 
		return nombre; 
	}
	public ValueProduct getValor() { 
		return valor; 
	}
}
