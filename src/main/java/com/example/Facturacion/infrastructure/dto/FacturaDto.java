package com.example.Facturacion.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class FacturaDto extends BaseEntity 
{
	@Column
	private String nombre;
	@Column
	private Double valor;
	@Column
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDto> item;
	
	public FacturaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public FacturaDto(String codigo, String nombre, Double valor, List<ItemDto> item) {
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
		this.item = item;
	}

	public List<ItemDto> getItem() {
		return item;
	}
	public void setItem(List<ItemDto> item) {
		this.item = item;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
