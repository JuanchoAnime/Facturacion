package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.domain.valueobjects.Cantidad;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Valor;

public class ItemDomain 
{
	private Cantidad cantidad;
	private Codigo codigo;
	private ProductoDomain producto;
	private Valor valor;
	
	private ItemDomain(Codigo codigo, Cantidad cantidad, ProductoDomain producto, Valor valor) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor = valor;
	}
	
	public Cantidad getCantidad() {
		return cantidad;
	}
	public ProductoDomain getProducto() {
		return producto;
	}
	public Valor getValor() {
		return valor;
	}
	public Codigo getCodigo() {
		return codigo;
	}
	
	public static ItemDomain of(Codigo codigo, Cantidad cantidad, ProductoDomain producto, Valor valor) 
	{
		return new ItemDomain(codigo, cantidad, producto, valor);
	}
}
