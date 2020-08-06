package com.example.Facturacion.infrastructure.rest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FacturaRestDto 
{
	private String codigo;
	private String nombre;
	private Double valor;
	private List<ItemRestDto> items;
}
