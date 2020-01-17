package com.example.Facturacion.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Facturacion.infrastructure.dto.FacturaDto;

@Repository
public interface IFacturaRepository extends JpaRepository<FacturaDto, String> {

}
