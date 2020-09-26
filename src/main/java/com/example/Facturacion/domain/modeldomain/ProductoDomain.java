package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.NameProduct;
import com.example.Facturacion.shared.domain.ValorProduct;

public class ProductoDomain 
{
	private final Codigo codigo;
	private final NameProduct nombre;
	private final ValorProduct valor;
	
	private ProductoDomain(Codigo codigo, NameProduct nombre, ValorProduct valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public static ProductoDomain of(Codigo codigo, NameProduct nombre, ValorProduct valor) {
		return new ProductoDomain(codigo, nombre, valor);
	}

	public Codigo getCodigo() { 
		return codigo; 
	}
	public NameProduct getNombre() { 
		return nombre; 
	}
	public ValorProduct getValor() { 
		return valor; 
	}
}
