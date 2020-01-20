package com.example.Facturacion.infrastructure.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@NoArgsConstructor
public class ProductoDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;

	@Column
	@Getter @Setter private String nombre;
	
	@Column
	@Getter @Setter private Double valor;
	
	public ProductoDto(String codigo, String nombre, Double valor) {
		super();
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
	}	
}
