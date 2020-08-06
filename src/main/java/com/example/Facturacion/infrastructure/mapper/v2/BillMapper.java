package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.infrastructure.dto.FacturaDto;
import com.example.Facturacion.infrastructure.rest.FacturaRest;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class BillMapper implements GenericMapper<FacturaRest, FacturaDomain, FacturaDto>
{
	public static BillMapper INSTANCE = new BillMapper();

	@Override
	public FacturaRest getRest(FacturaDomain domain) 
	{
		return new FacturaRest(domain.getCodigo().getValue(), domain.getNombre().getValue(), 
				domain.getValor().getValue(), ItemV2Mapper.INSTANCE.getListRest(domain.getItems()));
	}

	@Override
	public FacturaDto getDto(FacturaDomain domain) 
	{
		return new FacturaDto(domain.getCodigo().getValue(), domain.getNombre().getValue(), 
				domain.getValor().getValue(), ItemV2Mapper.INSTANCE.getListDto(domain.getItems()));
	}

	@Override
	public FacturaDomain getByRest(FacturaRest rest) 
	{
		return FacturaDomain.of(new Codigo(rest.getCodigo()), new Nombre(rest.getNombre()),
				new Valor(rest.getValor()), ItemV2Mapper.INSTANCE.getListByRest(rest.getItems()));
	}

	@Override
	public FacturaDomain getByDto(FacturaDto dto) 
	{
		return FacturaDomain.of(new Codigo(dto.getCodigo()), new Nombre(dto.getNombre()),
				new Valor(dto.getValor()), ItemV2Mapper.INSTANCE.getListByDto(dto.getItem()));
	}

}
