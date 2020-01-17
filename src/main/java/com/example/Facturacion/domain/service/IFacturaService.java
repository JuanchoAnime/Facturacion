package com.example.Facturacion.domain.service;

import java.util.List;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.shared.domain.Codigo;

public interface IFacturaService 
{
	List<FacturaDomain> GetAllFacturas();
	
	FacturaDomain ObtenerPorId(Codigo codigo);
	
	FacturaDomain GuardarFactura(FacturaDomain factura);
	
	FacturaDomain ActualizarFactura(FacturaDomain factura);
	
	void EliminarFacturaPorId(Codigo codigo);
}
