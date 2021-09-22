package com.ceiba.configuracion;

import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    /**
     * Beans del usuario
     */
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

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

}
