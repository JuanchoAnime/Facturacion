package com.example.Facturacion.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ItemRestDto 
{
	@Getter @Setter private String codigo;
	@Getter @Setter private int cantidad;
	@Getter @Setter private ProductoRestDto producto;
	@Getter @Setter private Double valor;
}
