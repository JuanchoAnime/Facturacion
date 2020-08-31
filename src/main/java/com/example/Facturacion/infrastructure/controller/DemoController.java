package com.example.Facturacion.infrastructure.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
    private MessageSource messageSource;
     
    @GetMapping
    public String index(Locale locale) {
        return messageSource.getMessage("error.notfound", null, locale);
    }
}