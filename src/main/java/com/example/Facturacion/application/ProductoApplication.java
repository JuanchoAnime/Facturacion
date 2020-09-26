package com.example.Facturacion.application;

import java.util.List;

import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.rest.ProductoRest;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.shared.domain.Codigo;

public class ProductoApplication 
{
	private ProductoService service;

	public ProductoApplication(ProductoService service) {
		this.service = service;
	}

	public List<ProductoRest> findAll()
	{
		return ProductMapper.INSTANCE.getListRest(service.findAll());
	}
	
	public ProductoRest findByCode(String codigo)
	{
		return ProductMapper.INSTANCE.getRest(service.findByCode(new Codigo(codigo)));
	}
	
	public ProductoRest save(ProductoRest product)
	{
		product.setCodigo(GetID.GetId());
		return ProductMapper.INSTANCE.getRest(service.save(ProductMapper.INSTANCE.getByRest(product)));
	}
	
	public ProductoRest update(ProductoRest product, String codigo)
	{
		product.setCodigo(codigo);
		return ProductMapper.INSTANCE.getRest(service.update((ProductMapper.INSTANCE.getByRest(product))));
	}
	
	public void deleteByCode(String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
