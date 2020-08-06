package com.example.Facturacion.infrastructure.mapper;

import com.example.Facturacion.domain.modeldomain.ItemDomain;
import com.example.Facturacion.shared.domain.Cantidad;
import com.example.Facturacion.infrastructure.dto.ItemDto;
import com.example.Facturacion.infrastructure.rest.ItemRestDto;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

public class ItemMapper implements MapperApiRest<ItemDomain, ItemDto>, MapperRepository<ItemDomain, ItemRestDto> {

	public static ItemMapper INSTANCE = new ItemMapper();

	@Override
	public ItemDomain dtoDominio(ItemRestDto o) {
		return ItemDomain.of(new Codigo(o.getCodigo())
				, new Cantidad(o.getCantidad())
				, ProductoMapper.INSTANCE.dtoDominio(o.getProducto())
				, new Valor(o.getValor()) 
		 );
	}

	@Override
	public ItemRestDto dominiodto(ItemDomain i) {
		return new ItemRestDto(i.getCodigo().getCodigo()
						  , i.getCantidad().getCantidad()
						  , ProductoMapper.INSTANCE.dominiodto(i.getProducto())
						  , i.getValor().getValor());
	}

	@Override
	public ItemDomain dtoDominioapi(ItemDto o) {
		return ItemDomain.of(new Codigo(o.getCodigo())
							, new Cantidad(o.getCantidad())
							, ProductoMapper.INSTANCE.dtoDominioapi(o.getProducto())
							, new Valor(o.getValor()));
	}

	@Override
	public ItemDto dominiodtoapi(ItemDomain i) {
		return new ItemDto(i.getCodigo().getCodigo()
						 , i.getCantidad().getCantidad()
						 , i.getValor().getValor()
						 , ProductoMapper.INSTANCE.dominiodtoapi(i.getProducto()));
	}


}
