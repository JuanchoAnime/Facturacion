package com.example.Facturacion.infrastructure.controller;

import java.util.List;

import com.example.Facturacion.domain.service.FacturaService;
import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.adapter.FacturaAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.application.FacturaApplication;
import com.example.Facturacion.infrastructure.dto.FacturaRestDto;

@RestController
@RequestMapping("/api/factura")
public class FacturaController 
{
	private FacturaApplication app;

	@Autowired
	public FacturaController(FacturaService service,
							 ProductoService serviceProducto){
		this.app = new FacturaApplication(service, serviceProducto);
	}
	
	@GetMapping
	public List<FacturaRestDto> findAll()
	{
		return app.findAll();
	}
	
	@GetMapping("/{id}")
	public FacturaRestDto findByCode(@PathVariable String id)
	{
		return app.findByCode(id);
	}
	
	@PostMapping
	public FacturaRestDto save(@RequestBody FacturaRestDto factura)
	{
		return app.save(factura);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByCode(@PathVariable String id)
	{
		app.deleteByCode(id);
	}
}

