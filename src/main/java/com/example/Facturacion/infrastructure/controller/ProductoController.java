package com.example.Facturacion.infrastructure.controller;

import java.util.List;

import com.example.Facturacion.domain.service.ProductoService;
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
	private ProductoApplication app;

	@Autowired
	public ProductoController(ProductoService productService) {
		this.app = new ProductoApplication(productService);
	}

	@GetMapping
	public List<ProductoRestDto> findAll()
	{
		return app.findAll();
	}
	
	@GetMapping("/{id}")
	public ProductoRestDto findByCode(@PathVariable String id)
	{
		return app.findByCode(id);
	}
	
	@PostMapping
	public ProductoRestDto save(@RequestBody ProductoRestDto producto)
	{
		return app.save(producto);
	}
	
	@PutMapping("/{id}")
	public ProductoRestDto update(@PathVariable String id, @RequestBody ProductoRestDto producto)
	{
		return app.update(producto, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByCode(@PathVariable String id)
	{
		app.deleteByCode(id);
	}
}
