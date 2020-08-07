package com.example.Facturacion.infrastructure.repository;

import static org.junit.Assert.assertEquals;

import com.example.Facturacion.application.GetID;
import com.example.Facturacion.infrastructure.dto.ProductoDto;
import com.example.Facturacion.infrastructure.repository.database.IProductoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductToRepositoryTest
{
    private final String code = GetID.GetId();
    private final String name = "Pony Malta";
    private final Double value = 6000.0;

    Logger logger = LoggerFactory.getLogger(ProductToRepositoryTest.class);

    private IProductoRepository productoRepository;

    @Autowired
    public ProductToRepositoryTest(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Test
    public void insertProduct()
    {
        logger.info("START TEST SAVE PROUCT REPOSITORY");
        ProductoDto p = productoRepository.save(new ProductoDto(code, name, value));
        assertEquals(code, p.getCodigo());
        assertEquals(name, p.getNombre());
        assertEquals(value, p.getValor());
        logger.info("FINALLY TEST SAVE PROUCT REPOSITORY");
    }

}
