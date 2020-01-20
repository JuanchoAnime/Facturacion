package com.example.Facturacion.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductoRestDto 
{
	@Getter @Setter private String codigo;
	@Getter @Setter private String nombre;
	@Getter @Setter private Double valor;
}
