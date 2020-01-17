package com.example.Facturacion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.infrastructure.dto.FacturaDto;
import com.example.Facturacion.infrastructure.dto.FacturaRestDto;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

public class FacturaMapper implements MapperApiRest<FacturaDomain, FacturaDto>, MapperRepository<FacturaDomain, FacturaRestDto> {

	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public FacturaDomain dtoDominio(FacturaRestDto o) {
		return FacturaDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor())
								, itemMapper.dtoDominio(o.getItems()));
	}

	@Override
	public FacturaRestDto dominiodto(FacturaDomain i) {
		return new FacturaRestDto(i.getCodigo().getCodigo()
							 , i.getNombre().getName()
							 , i.getValor().getValor()
							 , itemMapper.dominiodto(i.getItems()));
	}

	@Override
	public FacturaDomain dtoDominioapi(FacturaDto o) {
		return FacturaDomain.of(new Codigo(o.getCodigo())
							  , new Nombre(o.getNombre())
							  , new Valor(o.getValor())
							  , itemMapper.dtoDominioapi(o.getItem()));
	}

	@Override
	public FacturaDto dominiodtoapi(FacturaDomain i) {
		return new FacturaDto(i.getCodigo().getCodigo()
							, i.getNombre().getName()
							, i.getValor().getValor()
							, itemMapper.dominiodtoapi(i.getItems()));
	}

}
