package com.ceiba.libro.consulta;

import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarLibros {

    private final DaoLibro daoLibro;

    public ManejadorListarLibros(DaoLibro daoLibro) {
        this.daoLibro = daoLibro;
    }

    public List<DtoLibro> ejecutar() {
        return this.daoLibro.listar();
    }
}
