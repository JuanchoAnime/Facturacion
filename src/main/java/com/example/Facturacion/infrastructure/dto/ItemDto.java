package com.example.Facturacion.infrastructure.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemDto extends BaseEntity 
{
	@Column
	private int cantidad;
	
	@OneToOne(targetEntity = ProductoDto.class)
	private ProductoDto producto;
	
	@Column
	private Double valor;
	
	public ItemDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemDto(String codigo, int cantidad, Double valor, ProductoDto producto) {
		this.setCodigo(codigo);
		this.cantidad = cantidad;
		this.valor = valor;
		this.producto = producto;
	}


	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}


	public ProductoDto getProducto() {
		return producto;
	}
	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	} 
}
