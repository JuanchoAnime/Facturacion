package com.example.Facturacion.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.domain.service.IProductoService;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.infrastructure.repository.IProductoRepository;
import com.example.Facturacion.shared.domain.Codigo;

@Service
public class ProductoService implements IProductoService 
{
	@Autowired
	private ProductoMapper producMapper;
	@Autowired
	private IProductoRepository repo;
	
	@Override
	public List<ProductoDomain> GetAllProductos() 
	{
		return this.producMapper.dtoDominioapi(repo.findAll());
	}

	@Override
	public ProductoDomain ObtenerPorID(Codigo codigo) 
	{
		ProductoDto p = repo.findById(codigo.getCodigo()).get();
		return producMapper.dtoDominioapi(p);
	}

	@Override
	public ProductoDomain GuardarProducto(ProductoDomain producto) 
	{
		ProductoDto p = producMapper.dominiodtoapi(producto);
		return  producMapper.dtoDominioapi(repo.save(p));
	}

	@Override
	public ProductoDomain ActuaizarProducto(ProductoDomain producto) 
	{
		ProductoDto p = producMapper.dominiodtoapi(producto);
		return  producMapper.dtoDominioapi(repo.save(p));
	}

	@Override
	public void EliminarProducto(Codigo codigo)
	{
		repo.deleteById(codigo.getCodigo());
	}
}
