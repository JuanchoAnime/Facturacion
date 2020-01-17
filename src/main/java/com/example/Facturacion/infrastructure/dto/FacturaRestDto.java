package com.example.Facturacion.infrastructure.dto;

import java.util.List;

public class FacturaRestDto 
{
	private String codigo;
	private String nombre;
	private Double valor;
	private List<ItemRestDto> items;
	
	public FacturaRestDto(String codigo, String nombre, Double valor, List<ItemRestDto> items) 
	{
		this.codigo = codigo;
		this.nombre  =nombre;
		this.valor = valor;
		this.items = items;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public List<ItemRestDto> getItems() {
		return items;
	}
	public void setItems(List<ItemRestDto> items) {
		this.items = items;
	}
	
	
}
