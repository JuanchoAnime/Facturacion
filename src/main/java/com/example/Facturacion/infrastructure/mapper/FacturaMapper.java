package com.example.Facturacion.infrastructure.mapper;

import com.example.Facturacion.domain.modeldomain.FacturaDomain;
import com.example.Facturacion.infrastructure.dto.FacturaDto;
import com.example.Facturacion.infrastructure.rest.FacturaRest;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Nombre;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

public class FacturaMapper implements MapperApiRest<FacturaDomain, FacturaDto>, MapperRepository<FacturaDomain, FacturaRest> {

	public static FacturaMapper INSTANCE = new FacturaMapper();

	@Override
	public FacturaDomain dtoDominio(FacturaRest o) {
		return FacturaDomain.of(new Codigo(o.getCodigo())
								, new Nombre(o.getNombre())
								, new Valor(o.getValor())
								, ItemMapper.INSTANCE.dtoDominio(o.getItems()));
	}

	@Override
	public FacturaRest dominiodto(FacturaDomain i) {
		return new FacturaRest(i.getCodigo().getCodigo()
							 , i.getNombre().getName()
							 , i.getValor().getValor()
							 , ItemMapper.INSTANCE.dominiodto(i.getItems()));
	}

	@Override
	public FacturaDomain dtoDominioapi(FacturaDto o) {
		return FacturaDomain.of(new Codigo(o.getCodigo())
							  , new Nombre(o.getNombre())
							  , new Valor(o.getValor())
							  , ItemMapper.INSTANCE.dtoDominioapi(o.getItem()));
	}

	@Override
	public FacturaDto dominiodtoapi(FacturaDomain i) {
		return new FacturaDto(i.getCodigo().getCodigo()
							, i.getNombre().getName()
							, i.getValor().getValor()
							, ItemMapper.INSTANCE.dominiodtoapi(i.getItems()));
	}

}
