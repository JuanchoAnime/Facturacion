package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;

public class ProductoDomain 
{
	private Codigo codigo;
	private Nombre nombre;
	private Valor valor;
	
	private ProductoDomain(Codigo codigo, Nombre nombre, Valor valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public static ProductoDomain of(Codigo codigo, Nombre nombre, Valor valor) {
		return new ProductoDomain(codigo, nombre, valor);
	}

	public Codigo getCodigo() { 
		return codigo; 
	}
	public Nombre getNombre() { 
		return nombre; 
	}
	public Valor getValor() { 
		return valor; 
	}
}
