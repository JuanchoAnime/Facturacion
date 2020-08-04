package com.example.Facturacion.domain.service;

import java.util.List;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.shared.domain.Codigo;

public interface FacturaService
{
	List<FacturaDomain> findAll();
	
	FacturaDomain findByCode(Codigo codigo);
	
	FacturaDomain save(FacturaDomain factura);

	void deleteByCode(Codigo codigo);
}
