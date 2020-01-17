package com.example.Facturacion.application;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.domain.service.IFacturaService;
import com.example.Facturacion.domain.service.IProductoService;
import com.example.Facturacion.infrastructure.dto.FacturaRestDto;
import com.example.Facturacion.infrastructure.dto.ItemRestDto;
import com.example.Facturacion.infrastructure.dto.ProductoRestDto;
import com.example.Facturacion.infrastructure.mapper.FacturaMapper;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.shared.domain.Codigo;;

@Component
public class FacturaApplication 
{
	@Autowired
	private IFacturaService service;
	@Autowired
	private IProductoService serviceProducto;
	@Autowired
	private FacturaMapper mapper;
	@Autowired
	private ProductoMapper mapperProducto;

	public List<FacturaRestDto> ObtenerFacturas()
	{
		return mapper.dominiodto(service.GetAllFacturas());
	}
	
	public FacturaRestDto ObtenerFactura(String codigo) 
	{
		return mapper.dominiodto(service.ObtenerPorId(new Codigo(codigo)));
	}
	
	public FacturaRestDto GuardarFactura(FacturaRestDto factura) 
	{
		factura.setCodigo(GetID.GetId());
		List<ProductoRestDto> productrestdto = factura.getItems().stream().map(
														irdto -> BuscarProductByItem(irdto)
												 ).collect(Collectors.toList());
		factura.getItems().stream().forEach(item -> {
			item.setCodigo(GetID.GetId());
			item.setProducto(productrestdto.stream().filter(pro -> pro.getCodigo().equals(item.getProducto().getCodigo())).findFirst().get());
			item.setValor(item.getCantidad() * item.getProducto().getValor());
			
		});
		factura.setValor(factura.getItems().stream().mapToDouble(item -> item.getValor()).sum());
		return mapper.dominiodto(service.GuardarFactura(mapper.dtoDominio(factura)));
		
	}
	
	private ProductoRestDto BuscarProductByItem(ItemRestDto ird) 
	{
		return mapperProducto.dominiodto(
			serviceProducto.ObtenerPorID(
					new Codigo(ird.getProducto().getCodigo())
			)
		);
	}
	
	
	public FacturaRestDto ActualizarFactura(FacturaRestDto factura, String codigo) {
		factura.setCodigo(codigo);
		return null;
	}
	
	public void EliminarFactura (String codigo) 
	{
		service.EliminarFacturaPorId(new Codigo(codigo));
	}
}
