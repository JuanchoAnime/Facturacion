package com.example.Facturacion.domain.modeldomain;

import java.util.List;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;

public class FacturaDomain 
{
	private Codigo codigo;
	private Nombre nombre;
	private Valor valor;
	private List<ItemDomain> items;
	
	private FacturaDomain(Codigo codigo, Nombre nombre, Valor valor, List<ItemDomain> items) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.items = items;
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
	public List<ItemDomain> getItems() {
		return items;
	}
	
	public static FacturaDomain of(Codigo codigo, Nombre nombre, Valor valor, List<ItemDomain> items) {
		return new FacturaDomain(codigo, nombre, valor, items);
	}
}
