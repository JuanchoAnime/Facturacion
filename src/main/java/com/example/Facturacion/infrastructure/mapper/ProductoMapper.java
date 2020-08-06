package com.example.Facturacion.infrastructure.mapper;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.rest.ProductoRest;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

public class ProductoMapper implements MapperApiRest<ProductoDomain, ProductoDto>, MapperRepository<ProductoDomain, ProductoRest> {

	public static ProductoMapper INSTANCE = new ProductoMapper();

	@Override
	public ProductoDomain dtoDominio(ProductoRest o) {
		return ProductoDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor()));
	}

	@Override
	public ProductoRest dominiodto(ProductoDomain i) {
		return new ProductoRest(i.getCodigo().getValue(),
				i.getNombre().getValue(),
				i.getValor().getValue());
	}

	@Override
	public ProductoDomain dtoDominioapi(ProductoDto o) {
		return ProductoDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor()));
	}

	@Override
	public ProductoDto dominiodtoapi(ProductoDomain i) {
		return new ProductoDto( i.getCodigo().getValue(), 
				i.getNombre().getValue(), 
				i.getValor().getValue());
	}
}
