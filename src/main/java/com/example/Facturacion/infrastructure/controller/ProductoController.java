package com.example.Facturacion.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.application.ProductoApplication;
import com.example.Facturacion.infrastructure.dto.ProductoRestDto;

@RestController
@RequestMapping("/api/producto")
public class ProductoController
{
	@Autowired
	private ProductoApplication app;
	
	@GetMapping
	public List<ProductoRestDto> GetProductos()
	{
		return app.ObtenerProductos();
	}
	
	@GetMapping("/{id}")
	public ProductoRestDto GetProducto(@PathVariable String id) 
	{
		return app.ObtenerProducto(id);
	}
	
	@PostMapping
	public ProductoRestDto AgregarProducto(@RequestBody ProductoRestDto producto) 
	{
		return app.GuardarProducto(producto);
	}
	
	@PutMapping("/{id}")
	public ProductoRestDto ActualizarProducto(@PathVariable String id, @RequestBody ProductoRestDto producto) 
	{
		return app.ActualizarProducto(producto, id);
	}
	
	@DeleteMapping("/{id}")
	public void EliminarProducto(@PathVariable String id) 
	{
		app.EliminarProducto(id);
	}
}
