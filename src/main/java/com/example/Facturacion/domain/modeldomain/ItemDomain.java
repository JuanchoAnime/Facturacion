package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.CantidadItem;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.ValorItem;

public class ItemDomain 
{
	private final CantidadItem cantidad;
	private final Codigo codigo;
	private final ProductoDomain producto;
	private final ValorItem valor;
	
	private ItemDomain(Codigo codigo, CantidadItem cantidad, ProductoDomain producto, ValorItem valor) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor = valor;
	}
	
	public CantidadItem getCantidad() {
		return cantidad;
	}
	public ProductoDomain getProducto() {
		return producto;
	}
	public ValorItem getValor() {
		return valor;
	}
	public Codigo getCodigo() {
		return codigo;
	}
	
	public static ItemDomain of(Codigo codigo, CantidadItem cantidad, ProductoDomain producto, ValorItem valor) 
	{
		return new ItemDomain(codigo, cantidad, producto, valor);
	}
}
