package com.example.Facturacion.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.shared.domain.Codigo;

@Service
public interface IProductoService 
{
	List<ProductoDomain> GetAllProductos();
	
	ProductoDomain ObtenerPorID(Codigo codigo);
	
	ProductoDomain GuardarProducto(ProductoDomain producto);
	
	ProductoDomain ActuaizarProducto(ProductoDomain producto);
	
	void EliminarProducto(Codigo codigo);
}
