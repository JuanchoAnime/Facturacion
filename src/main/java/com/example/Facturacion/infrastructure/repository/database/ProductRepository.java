package com.example.Facturacion.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Facturacion.infrastructure.dto.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, String> {
	
}
