package com.example.Facturacion.infrastructure.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class FacturaRestDto 
{
	@Getter @Setter private String codigo;
	@Getter @Setter private String nombre;
	@Getter @Setter private Double valor;
	@Getter @Setter private List<ItemRestDto> items;
}
