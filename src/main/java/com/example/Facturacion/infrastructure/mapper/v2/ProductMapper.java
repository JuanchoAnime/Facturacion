package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.rest.ProductoRest;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class ProductMapper implements GenericMapper<ProductoRest, ProductoDomain, ProductoDto>
{
	public static ProductMapper INSTANCE = new ProductMapper(); 

	@Override
	public ProductoRest getRest(ProductoDomain domain) 
	{
		return new ProductoRest(domain.getCodigo().getValue(), 
				domain.getNombre().getValue(), domain.getValor().getValue());
	}

	@Override
	public ProductoDto getDto(ProductoDomain domain) 
	{
		return new ProductoDto(domain.getCodigo().getValue(), 
				domain.getNombre().getValue(), domain.getValor().getValue());
	}

	@Override
	public ProductoDomain getByRest(ProductoRest rest) 
	{
		return ProductoDomain.of(new Codigo(rest.getCodigo()), 
				new Nombre(rest.getNombre()), new Valor(rest.getValor()));
	}

	@Override
	public ProductoDomain getByDto(ProductoDto dto) 
	{
		return ProductoDomain.of(new Codigo(dto.getCodigo()), 
				new Nombre(dto.getNombre()), new Valor(dto.getValor()));
	}

}
