package com.example.Facturacion.application;

import java.util.List;

import com.example.Facturacion.domain.service.ProductService;
import com.example.Facturacion.infrastructure.rest.ProductRest;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.shared.domain.Codigo;

public class ProductApplication 
{
	private ProductService service;

	public ProductApplication(ProductService service) {
		this.service = service;
	}

	public List<ProductRest> findAll()
	{
		return ProductMapper.INSTANCE.getListRest(service.findAll());
	}
	
	public ProductRest findByCode(String codigo)
	{
		return ProductMapper.INSTANCE.getRest(service.findByCode(new Codigo(codigo)));
	}
	
	public ProductRest save(ProductRest product)
	{
		product.setCodigo(GetID.GetId());
		return ProductMapper.INSTANCE.getRest(service.save(ProductMapper.INSTANCE.getByRest(product)));
	}
	
	public ProductRest update(ProductRest product, String codigo)
	{
		product.setCodigo(codigo);
		return ProductMapper.INSTANCE.getRest(service.update((ProductMapper.INSTANCE.getByRest(product))));
	}
	
	public void deleteByCode(String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
