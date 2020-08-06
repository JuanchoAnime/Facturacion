package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;

import com.example.Facturacion.domain.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.infrastructure.mapper.FacturaMapper;
import com.example.Facturacion.infrastructure.repository.database.IFacturaRepository;
import com.example.Facturacion.shared.domain.Codigo;

@Service
public class FacturaAdapter implements FacturaService
{
	private IFacturaRepository repo;

	@Autowired
	public FacturaAdapter(IFacturaRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<FacturaDomain> findAll() {
		return FacturaMapper.INSTANCE.dtoDominioapi(repo.findAll());
	}

	@Override
	public FacturaDomain findByCode(Codigo codigo)
	{
		return FacturaMapper.INSTANCE.dtoDominioapi(repo.findById(codigo.getValue()).get());
	}

	@Override
	public FacturaDomain save(FacturaDomain factura)
	{
		return FacturaMapper.INSTANCE.dtoDominioapi(repo.save(FacturaMapper.INSTANCE.dominiodtoapi(factura)));
	}

	@Override
	public void deleteByCode(Codigo codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getValue());
	}

}
