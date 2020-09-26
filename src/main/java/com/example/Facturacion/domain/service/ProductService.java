package com.example.Facturacion.domain.service;

import java.util.List;

import com.example.Facturacion.domain.modeldomain.Product;
import com.example.Facturacion.shared.domain.Codigo;

public interface ProductService
{
	List<Product> findAll();

	Product findByCode(Codigo codigo);

	List<Product> findByCodes(List<Codigo> codes);
	
	Product save(Product producto);
	
	Product update(Product producto);
	
	void deleteByCode(Codigo codigo);
}
