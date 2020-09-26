package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.ItemDomain;
import com.example.Facturacion.infrastructure.dto.ItemDto;
import com.example.Facturacion.infrastructure.rest.ItemRest;
import com.example.Facturacion.shared.domain.CantidadItem;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.ValorItem;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class ItemV2Mapper implements GenericMapper<ItemRest, ItemDomain, ItemDto> 
{
	public static ItemV2Mapper INSTANCE = new ItemV2Mapper();

	@Override
	public ItemRest getRest(ItemDomain domain) 
	{
		return new ItemRest(domain.getCodigo().getValue(), domain.getCantidad().getValue(),
				ProductMapper.INSTANCE.getRest(domain.getProducto()), domain.getValor().getValue());
	}

	@Override
	public ItemDto getDto(ItemDomain domain) 
	{
		return new ItemDto(domain.getCodigo().getValue(), domain.getCantidad().getValue(),
				domain.getValor().getValue(), ProductMapper.INSTANCE.getDto(domain.getProducto()));
	}

	@Override
	public ItemDomain getByRest(ItemRest rest) 
	{
		return ItemDomain.of(new Codigo(rest.getCodigo()), new CantidadItem(rest.getCantidad()), 
				ProductMapper.INSTANCE.getByRest(rest.getProducto()), new ValorItem(rest.getValor()));
	}

	@Override
	public ItemDomain getByDto(ItemDto dto) 
	{
		return ItemDomain.of(new Codigo(dto.getCodigo()), new CantidadItem(dto.getCantidad()), 
				ProductMapper.INSTANCE.getByDto(dto.getProducto()), new ValorItem(dto.getValor()));
	}

}
