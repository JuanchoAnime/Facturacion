package com.example.Facturacion.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.infrastructure.rest.DemoRest;

@RestController
@RequestMapping("/api/demo")
public class DemoController 
{
	@PostMapping
	public String Data(@RequestBody DemoRest demo) 
	{
		if(!demo.getName().matches("[A-Za-z\\sñÑáéíóúÁÉÍÓÚ()]*")) {
			return "MALO";
		}
		
		return "BUENO";
	}
}
