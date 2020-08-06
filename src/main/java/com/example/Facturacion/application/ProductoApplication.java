package com.example.Facturacion.application;

import java.util.List;

import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.rest.ProductoRestDto;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.shared.domain.Codigo;

public class ProductoApplication 
{
	private ProductoService service;

	public ProductoApplication(ProductoService service) {
		this.service = service;
	}

	public List<ProductoRestDto> findAll()
	{
		return ProductoMapper.INSTANCE.dominiodto(service.findAll());
	}
	
	public ProductoRestDto findByCode(String codigo)
	{
		return ProductoMapper.INSTANCE.dominiodto(service.findByCode(new Codigo(codigo)));
	}
	
	public ProductoRestDto save(ProductoRestDto product)
	{
		product.setCodigo(GetID.GetId());
		return ProductoMapper.INSTANCE.dominiodto(service.save(ProductoMapper.INSTANCE.dtoDominio(product)));
	}
	
	public ProductoRestDto update(ProductoRestDto product, String codigo)
	{
		product.setCodigo(codigo);
		return ProductoMapper.INSTANCE.dominiodto(service.update((ProductoMapper.INSTANCE.dtoDominio(product))));
	}
	
	public void deleteByCode(String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
