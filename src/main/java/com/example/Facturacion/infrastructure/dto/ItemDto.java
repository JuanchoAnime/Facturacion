package com.example.Facturacion.infrastructure.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@NoArgsConstructor
public class ItemDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;

	@Column
	@Getter @Setter private int cantidad;
	
	@OneToOne(targetEntity = ProductoDto.class)
	@Getter @Setter private ProductoDto producto;
	
	@Column
	@Getter @Setter private Double valor;
	
	public ItemDto(String codigo, int cantidad, Double valor, ProductoDto producto) {
		this.setCodigo(codigo);
		this.cantidad = cantidad;
		this.valor = valor;
		this.producto = producto;
	}
}
