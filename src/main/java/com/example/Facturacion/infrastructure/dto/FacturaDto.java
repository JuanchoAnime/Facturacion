package com.example.Facturacion.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@Getter
@Setter
public class FacturaDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	@Column
	private String nombre;
	@Column
	private Double valor;
	@Column
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDto> item;
	
	public FacturaDto(String codigo, String nombre, Double valor, List<ItemDto> item) {
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
		this.item = item;
	}
}
