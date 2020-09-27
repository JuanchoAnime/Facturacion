package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.Product;
import com.example.Facturacion.domain.service.ProductService;
import com.example.Facturacion.infrastructure.dto.ProductDto;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.infrastructure.repository.database.ProductRepository;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.infrastructure.Util.Util;

@Service
public class ProductAdapter implements ProductService
{
	private ProductRepository repo;

	@Autowired
	public ProductAdapter(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Product> findAll(Pageable pageable)
	{
		return ProductMapper.INSTANCE.getListByDto(ProductMapper.INSTANCE.getDtoByPage(repo.findAll(pageable)));
	}

	@Override
	public Product findByCode(Codigo codigo)
	{
		Optional<ProductDto> product = repo.findById(codigo.getValue());
		if(!product.isPresent()) {
			Util.notFoundException("exception.productInvalid", codigo.getValue());
			return null;
		}
		return ProductMapper.INSTANCE.getByDto(product.get());
	}

	@Override
	public List<Product> findByCodes(List<Codigo> codes)
	{
		return  ProductMapper.INSTANCE.getListByDto(repo.findAllById(
				codes.stream().map(Codigo::getValue).collect(Collectors.toList())
		));
	}

	@Override
	public Product save(Product producto)
	{
		ProductDto p = ProductMapper.INSTANCE.getDto(producto);
		return  ProductMapper.INSTANCE.getByDto(repo.save(p));
	}

	@Override
	public Product update(Product producto)
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
