package com.example.Facturacion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Facturacion.domain.modeldomain.ItemDomain;
import com.example.Facturacion.domain.valueobjects.Cantidad;
import com.example.Facturacion.infrastructure.dto.ItemDto;
import com.example.Facturacion.infrastructure.dto.ItemRestDto;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Valor;
import com.example.Facturacion.shared.infrastructure.MapperApiRest;
import com.example.Facturacion.shared.infrastructure.MapperRepository;

@Component
public class ItemMapper implements MapperApiRest<ItemDomain, ItemDto>, MapperRepository<ItemDomain, ItemRestDto> {
	
	@Autowired
	private ProductoMapper productMapper;

	@Override
	public ItemDomain dtoDominio(ItemRestDto o) {
		return ItemDomain.of(new Codigo(o.getCodigo())
				, new Cantidad(o.getCantidad())
				, productMapper.dtoDominio(o.getProducto())
				, new Valor(o.getValor()) 
		 );
	}

	@Override
	public ItemRestDto dominiodto(ItemDomain i) {
		return new ItemRestDto(i.getCodigo().getCodigo()
						  , i.getCantidad().getCantidad()
						  , productMapper.dominiodto(i.getProducto())
						  , i.getValor().getValor());
	}

	@Override
	public ItemDomain dtoDominioapi(ItemDto o) {
		return ItemDomain.of(new Codigo(o.getCodigo())
							, new Cantidad(o.getCantidad())
							, productMapper.dtoDominioapi(o.getProducto())
							, new Valor(o.getValor()));
	}

	@Override
	public ItemDto dominiodtoapi(ItemDomain i) {
		return new ItemDto(i.getCodigo().getCodigo()
						 , i.getCantidad().getCantidad()
						 , i.getValor().getValor()
						 , productMapper.dominiodtoapi(i.getProducto()));
	}


}
