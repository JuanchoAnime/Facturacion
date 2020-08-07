package com.example.Facturacion.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TestDbConfiguration
{
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource datasource  = new DriverManagerDataSource();
        datasource.setDriverClassName("org.hibernate.dialect.PostgreSQLDialect");
        datasource.setUrl("jdbc:postgresql://localhost:5432/factura_test");
        datasource.setUsername("postgres");
        datasource.setPassword("root");
        return datasource;
    }
}
