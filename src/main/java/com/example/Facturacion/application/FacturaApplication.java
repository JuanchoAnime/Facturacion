package com.example.Facturacion.application;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Facturacion.domain.service.FacturaService;
import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.dto.FacturaRestDto;
import com.example.Facturacion.infrastructure.dto.ProductoRestDto;
import com.example.Facturacion.infrastructure.mapper.FacturaMapper;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.shared.domain.Codigo;;

public class FacturaApplication 
{
	private FacturaService service;
	private ProductoService serviceProducto;

	public FacturaApplication(FacturaService service,
							  ProductoService serviceProducto) {
		this.service = service;
		this.serviceProducto = serviceProducto;
	}

	public List<FacturaRestDto> findAll()
	{
		return FacturaMapper.INSTANCE.dominiodto(service.findAll());
	}
	
	public FacturaRestDto findByCode(String codigo)
	{
		return FacturaMapper.INSTANCE.dominiodto(service.findByCode(new Codigo(codigo)));
	}
	
	public FacturaRestDto save(FacturaRestDto factura)
	{
		factura.setCodigo(GetID.GetId());
		List<ProductoRestDto> productrestdto =  ProductoMapper.INSTANCE.dominiodto(serviceProducto.findByCodes(
				factura.getItems().stream().map(irdto -> new Codigo(irdto.getProducto().getCodigo())).collect(Collectors.toList())
		));
		factura.getItems().stream().forEach(item -> {
			item.setCodigo(GetID.GetId());
			item.setProducto(productrestdto.stream().filter(pro -> pro.getCodigo().equals(item.getProducto().getCodigo())).findFirst().get());
			item.setValor(item.getCantidad() * item.getProducto().getValor());
			
		});
		factura.setValor(factura.getItems().stream().mapToDouble(item -> item.getValor()).sum());
		return FacturaMapper.INSTANCE.dominiodto(service.save(FacturaMapper.INSTANCE.dtoDominio(factura)));
		
	}

	public void deleteByCode (String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
