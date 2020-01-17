package com.example.Facturacion.infrastructure.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;

	@Column
	private String nombre;
	
	@Column
	private Double valor;
	
	public ProductoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductoDto(String codigo, String nombre, Double valor) {
		super();
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
