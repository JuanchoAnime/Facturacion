package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.ProductoDomain;
import com.example.Facturacion.domain.service.ProductoService;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.infrastructure.repository.database.IProductoRepository;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.infrastructure.exception.ProductInvalidException;

@Service
public class ProductoAdapter implements ProductoService
{
	private IProductoRepository repo;
	private MessageSource messageSource;

	@Autowired
	public ProductoAdapter(IProductoRepository repo,
			MessageSource messageSource) {
		this.repo = repo;
		this.messageSource = messageSource;
	}

	@Override
	public List<ProductoDomain> findAll()
	{
		return ProductMapper.INSTANCE.getListByDto(repo.findAll());
	}

	@Override
	public ProductoDomain findByCode(Codigo codigo)
	{
		Optional<ProductoDto> product = repo.findById(codigo.getValue());
		if(!product.isPresent()) {
			throw new ProductInvalidException(messageSource);
		}
		return ProductMapper.INSTANCE.getByDto(product.get());
	}

	@Override
	public List<ProductoDomain> findByCodes(List<Codigo> codes)
	{
		return  ProductMapper.INSTANCE.getListByDto(repo.findAllById(
				codes.stream().map(Codigo::getValue).collect(Collectors.toList())
		));
	}

	@Override
	public ProductoDomain save(ProductoDomain producto)
	{
		ProductoDto p = ProductMapper.INSTANCE.getDto(producto);
		return  ProductMapper.INSTANCE.getByDto(repo.save(p));
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
		repo.deleteById(codigo.getValue());
	}
}
