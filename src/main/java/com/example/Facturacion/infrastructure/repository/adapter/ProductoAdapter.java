package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.mapper.ProductoMapper;
import com.example.Facturacion.infrastructure.repository.database.IProductoRepository;
import com.example.Facturacion.shared.domain.Codigo;

@Service
public class ProductoAdapter implements ProductoService
{
	private IProductoRepository repo;

	@Autowired
	public ProductoAdapter(IProductoRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<ProductoDomain> findAll()
	{
		return ProductoMapper.INSTANCE.dtoDominioapi(repo.findAll());
	}

	@Override
	public ProductoDomain findByCode(Codigo codigo)
	{
		ProductoDto p = repo.findById(codigo.getCodigo()).get();
		return ProductoMapper.INSTANCE.dtoDominioapi(p);
	}

	@Override
	public List<ProductoDomain> findByCodes(List<Codigo> codes)
	{
		return  ProductoMapper.INSTANCE.dtoDominioapi(repo.findAllById(
				codes.stream().map(c -> c.getCodigo()).collect(Collectors.toList())
		));
	}

	@Override
	public ProductoDomain save(ProductoDomain producto)
	{
		ProductoDto p = ProductoMapper.INSTANCE.dominiodtoapi(producto);
		return  ProductoMapper.INSTANCE.dtoDominioapi(repo.save(p));
	}

	@Override
	public ProductoDomain update(ProductoDomain producto)
	{
		this.findByCode(producto.getCodigo());
		return  this.save(producto);
	}

	@Override
	public void deleteByCode(Codigo codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getCodigo());
	}
}
