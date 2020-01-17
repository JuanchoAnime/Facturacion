package com.example.Facturacion.infrastructure.dto;

public class ItemRestDto 
{
	private String codigo;
	private int cantidad;
	private ProductoRestDto producto;
	private Double valor;
	
	public ItemRestDto(String codigo, int cantidad, ProductoRestDto producto, Double valor) 
	{
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor = valor;
	}
	
	public String getCodigo() { 
		return codigo; 
	}
	public void setCodigo(String codigo) { 
		this.codigo = codigo; 
	}
	
	public int getCantidad() { 
		return cantidad; 
	}
	public void setCantidad(int cantidad) { 
		this.cantidad = cantidad; 
	}
	
	public ProductoRestDto getProducto() { 
		return producto; 
	}
	public void setProducto(ProductoRestDto producto) { 
		this.producto = producto; 
	}
	
	public Double getValor() { 
		return valor; 
	}
	public void setValor(Double valor) { 
		this.valor = valor; 
	}
}
