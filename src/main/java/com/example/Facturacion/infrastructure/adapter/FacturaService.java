package com.example.Facturacion.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.domain.service.IFacturaService;
import com.example.Facturacion.infrastructure.mapper.FacturaMapper;
import com.example.Facturacion.infrastructure.repository.IFacturaRepository;
import com.example.Facturacion.shared.domain.Codigo;

@Service
public class FacturaService implements IFacturaService {

	@Autowired
	private IFacturaRepository repo;
	@Autowired
	private FacturaMapper mapper;
	
	@Override
	public List<FacturaDomain> GetAllFacturas() {
		return mapper.dtoDominioapi(repo.findAll());
	}

	@Override
	public FacturaDomain ObtenerPorId(Codigo codigo) 
	{
		return mapper.dtoDominioapi(repo.findById(codigo.getCodigo()).get());
	}

	@Override
	public FacturaDomain GuardarFactura(FacturaDomain factura) 
	{
		return mapper.dtoDominioapi(repo.save(mapper.dominiodtoapi(factura)));
	}

	@Override
	public FacturaDomain ActualizarFactura(FacturaDomain factura) 
	{
		return mapper.dtoDominioapi(repo.save(mapper.dominiodtoapi(factura)));
	}

	@Override
	public void EliminarFacturaPorId(Codigo codigo) 
	{
		repo.deleteById(codigo.getCodigo());
	}

}
