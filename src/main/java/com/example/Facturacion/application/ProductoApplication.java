package com.example.Facturacion.application;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.domain.service.IProductoService;
import com.example.Facturacion.infrastructure.dto.ProductoRestDto;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.shared.domain.Codigo;
@Component
public class ProductoApplication 
{
	@Autowired
	private IProductoService service;
	@Autowired
	private ProductoMapper proMapper;
	
	public List<ProductoRestDto> ObtenerProductos()
	{
		return proMapper.dominiodto(service.GetAllProductos());
	}
	
	public ProductoRestDto ObtenerProducto(String codigo)
	{
		ProductoDomain p = service.ObtenerPorID(new Codigo(codigo));
		return proMapper.dominiodto(p);
	}
	
	public ProductoRestDto GuardarProducto(ProductoRestDto product) 
	{
		product.setCodigo(GetID.GetId());
		ProductoDomain p = service.GuardarProducto(proMapper.dtoDominio(product));
		return proMapper.dominiodto(p);
	}
	
	public ProductoRestDto ActualizarProducto(ProductoRestDto product, String codigo) 
	{
		product.setCodigo(codigo);
		ProductoDomain p = service.ActuaizarProducto((proMapper.dtoDominio(product)));
		return proMapper.dominiodto(p);
	}
	
	public void EliminarProducto(String codigo)
	{
		service.EliminarProducto(new Codigo(codigo));
	}
	
	
}
