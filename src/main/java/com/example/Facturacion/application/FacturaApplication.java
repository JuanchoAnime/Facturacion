package com.example.Facturacion.application;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Facturacion.domain.service.FacturaService;
import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.rest.FacturaRest;
import com.example.Facturacion.infrastructure.rest.ItemRest;
import com.example.Facturacion.infrastructure.rest.ProductoRest;
import com.example.Facturacion.infrastructure.mapper.v2.BillMapper;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.shared.domain.Codigo;

public class FacturaApplication 
{
	private FacturaService service;
	private ProductoService serviceProducto;

	public FacturaApplication(FacturaService service,
							  ProductoService serviceProducto) {
		this.service = service;
		this.serviceProducto = serviceProducto;
	}

	public List<FacturaRest> findAll()
	{
		return BillMapper.INSTANCE.getListRest(service.findAll());
	}
	
	public FacturaRest findByCode(String codigo)
	{
		return BillMapper.INSTANCE.getRest(service.findByCode(new Codigo(codigo)));
	}
	
	public FacturaRest save(FacturaRest factura)
	{
		factura.setCodigo(GetID.GetId());
		List<ProductoRest> productrestdto =  ProductMapper.INSTANCE.getListRest(serviceProducto.findByCodes(
				factura.getItems().stream()
								  .map(irdto -> new Codigo(irdto.getProducto().getCodigo()))
								  .collect(Collectors.toList())
		));
		factura.getItems().stream().forEach(item -> {
			item.setCodigo(GetID.GetId());
			item.setProducto(productrestdto.stream()
											.filter(pro -> pro.getCodigo().equals(item.getProducto().getCodigo()))
											.findFirst().get());
			item.setValor(item.getCantidad() * item.getProducto().getValor());
			
		});
		factura.setValor(factura.getItems().stream().mapToDouble(ItemRest::getValor).sum());
		return BillMapper.INSTANCE.getRest(service.save(BillMapper.INSTANCE.getByRest(factura)));
		
	}

	public void deleteByCode (String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
