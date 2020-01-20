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

import com.example.Facturacion.application.FacturaApplication;
import com.example.Facturacion.infrastructure.dto.FacturaRestDto;

@RestController
@RequestMapping("/api/factura")
public class FacturaController 
{
	@Autowired
	private FacturaApplication app;
	
	@GetMapping
	public List<FacturaRestDto> GetFacturas()
	{
		return app.ObtenerFacturas();
	}
	
	@GetMapping("/{id}")
	public FacturaRestDto GetFactura(@PathVariable String id)
	{
		return app.ObtenerFactura(id);
	}
	
	@PostMapping
	public FacturaRestDto AgregarFactura(@RequestBody FacturaRestDto factura)
	{
		return app.GuardarFactura(factura);
	}
	
	@PutMapping("/{id}")
	public FacturaRestDto ActualizarFactura(@PathVariable String id, @RequestBody FacturaRestDto factura)
	{
		return app.ActualizarFactura(factura, id);
	}
	
	@DeleteMapping("/{id}")
	public void EliminarFactura(@PathVariable String id) 
	{
		app.EliminarFactura(id);
	}
}

