package com.example.Facturacion.domain.modeldomain;

import java.util.List;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.NameBill;
import com.example.Facturacion.shared.domain.ValueBill;

public class FacturaDomain 
{
	private final Codigo codigo;
	private final NameBill nombre;
	private final ValueBill valor;
	private final List<ItemDomain> items;
	
	private FacturaDomain(Codigo codigo, NameBill nombre, ValueBill valor, List<ItemDomain> items) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.items = items;
	}
	
	public Codigo getCodigo() {
		return codigo;
	}
	public NameBill getNombre() {
		return nombre;
	}
	public ValueBill getValor() {
		return valor;
	}
	public List<ItemDomain> getItems() {
		return items;
	}
	
	public static FacturaDomain of(Codigo codigo, NameBill nombre, ValueBill valor, List<ItemDomain> items) {
		return new FacturaDomain(codigo, nombre, valor, items);
	}
}
