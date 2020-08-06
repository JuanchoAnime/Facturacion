package com.example.Facturacion.infrastructure.mapper;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.rest.ProductoRestDto;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

public class ProductoMapper implements MapperApiRest<ProductoDomain, ProductoDto>, MapperRepository<ProductoDomain, ProductoRestDto> {

	public static ProductoMapper INSTANCE = new ProductoMapper();

	@Override
	public ProductoDomain dtoDominio(ProductoRestDto o) {
		return ProductoDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor()));
	}

	@Override
	public ProductoRestDto dominiodto(ProductoDomain i) {
		return new ProductoRestDto(i.getCodigo().getCodigo(), i.getNombre().getName(), i.getValor().getValor());
	}

	@Override
	public ProductoDomain dtoDominioapi(ProductoDto o) {
		return ProductoDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor()));
	}

	@Override
	public ProductoDto dominiodtoapi(ProductoDomain i) {
		return new ProductoDto( i.getCodigo().getCodigo(), i.getNombre().getName(), i.getValor().getValor());
	}

	
	
	

}
