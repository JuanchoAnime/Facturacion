package com.example.Facturacion.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductoRestDto 
{
	private String codigo;
	private String nombre;
	private Double valor;
}
