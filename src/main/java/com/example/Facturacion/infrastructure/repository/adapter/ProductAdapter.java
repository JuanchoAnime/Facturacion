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
import com.example.Facturacion.shared.domain.Id;
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
		return ProductMapper.INSTANCE.getListByDto(repo.findAll(pageable).toList());
	}

	@Override
	public Product findByCode(Id codigo)
	{
		Optional<ProductDto> product = repo.findById(codigo.getValue());
		if(!product.isPresent()) {
			Util.notFoundException("exception.productInvalid", codigo.getValue().toString());
			return null;
		}
		return ProductMapper.INSTANCE.getByDto(product.get());
	}

	@Override
	public List<Product> findByCodes(List<Id> codes)
	{
		return  ProductMapper.INSTANCE.getListByDto(repo.findAllById(
				codes.stream().map(Id::getValue).collect(Collectors.toList())
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
		this.findByCode(producto.getId());
		return  this.save(producto);
	}

	@Override
	public void deleteByCode(Id codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getValue());
	}
}
