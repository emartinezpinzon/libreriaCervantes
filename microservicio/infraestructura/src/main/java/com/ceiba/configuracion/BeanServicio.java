package com.ceiba.configuracion;

import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioCrearFactura;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    /**
     * Beans del libro
     */
    @Bean
    public ServicioCrearLibro servicioCrearLibro(RepositorioLibro repositorioLibro) {
        return new ServicioCrearLibro(repositorioLibro);
    }

    @Bean
    public ServicioActualizarLibro servicioActualizarLibro(RepositorioLibro repositorioLibro) {
        return new ServicioActualizarLibro(repositorioLibro);
    }

    /**
     * Beans de compra
     */
    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        return new ServicioCrearCompra(repositorioCompra, repositorioLibro, daoLibro);
    }

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioActualizarCompra(repositorioCompra);
    }

    /**
     * Beans de factura
     */
    @Bean
    public ServicioCrearFactura servicioCrearFactura(RepositorioFactura repositorioFactura, DaoCompra daoCompra) {
        return new ServicioCrearFactura(repositorioFactura, daoCompra);
    }
}
