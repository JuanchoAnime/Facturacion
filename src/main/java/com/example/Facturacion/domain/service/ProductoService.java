package com.example.Facturacion.domain.service;

import java.util.List;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.shared.domain.Codigo;

public interface ProductoService
{
	List<ProductoDomain> findAll();

	ProductoDomain findByCode(Codigo codigo);

	List<ProductoDomain> findByCodes(List<Codigo> codes);
	
	ProductoDomain save(ProductoDomain producto);
	
	ProductoDomain update(ProductoDomain producto);
	
	void deleteByCode(Codigo codigo);
}
