package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;

import com.example.Facturacion.domain.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.infrastructure.dto.FacturaDto;
import com.example.Facturacion.infrastructure.mapper.v2.BillMapper;
import com.example.Facturacion.infrastructure.repository.database.IFacturaRepository;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.infrastructure.exception.BillInvalidException;

@Service
public class FacturaAdapter implements FacturaService
{
	private IFacturaRepository repo;
	private MessageSource messageSource;

	@Autowired
	public FacturaAdapter(IFacturaRepository repo, 
			MessageSource messageSource) {
		this.repo = repo;
	}

	@Override
	public List<FacturaDomain> findAll() {
		return BillMapper.INSTANCE.getListByDto(repo.findAll());
	}

	@Override
	public FacturaDomain findByCode(Codigo codigo)
	{
		Optional<FacturaDto> bill = repo.findById(codigo.getValue());
		if(!bill.isPresent()) {
			throw new BillInvalidException(messageSource);
		}
		return BillMapper.INSTANCE.getByDto(bill.get());
	}

	@Override
	public FacturaDomain save(FacturaDomain factura)
	{
		return BillMapper.INSTANCE.getByDto(repo.save(BillMapper.INSTANCE.getDto(factura)));
	}

	@Override
	public void deleteByCode(Codigo codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getValue());
	}

}
