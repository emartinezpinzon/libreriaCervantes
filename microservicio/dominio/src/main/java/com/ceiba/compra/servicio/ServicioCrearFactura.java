package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioCrearFactura {

    private static final String COMPRAS_NO_REGISTRADAS = "No hay compras registradas";
    private static final String CATEGORIA_LIBRO_EDUCACION = "Educación";
    private static final float DESCUENTO_LIBRO_EDUCACION = 0.2F;
    private static final float DESCUENTO_SEGUNDO_LIBRO = 0.5F;

    private List<DtoCompra> comprasEducacion = new ArrayList<>();
    private List<DtoCompra> comprasOtros = new ArrayList<>();

    private final RepositorioFactura repositorioFactura;
    private final DaoCompra daoCompra;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura,
                                DaoCompra daoCompra) {
        this.repositorioFactura = repositorioFactura;
        this.daoCompra = daoCompra;
    }

    public Long ejecutar(Factura factura) {
        List<DtoCompra> compras = daoCompra.listar();

        validarExistenciaLibrosEnCompra(compras.size());
        separarCategoriasCompras(compras);

        factura.setFechaCompra(LocalDate.now());
        factura.setPrecioFinal(calcularPrecioFinal());
        return this.repositorioFactura.crear(factura);
    }

    private void validarExistenciaLibrosEnCompra(int compras) {
        if (compras == 0)
            throw new ExcepcionSinDatos(COMPRAS_NO_REGISTRADAS);
    }

    private void separarCategoriasCompras(List<DtoCompra> compras) {
        for (DtoCompra compra: compras)
            if (compra.getCategoria().equals(CATEGORIA_LIBRO_EDUCACION))
                comprasEducacion.add(compra);
            else
                comprasOtros.add(compra);
    }

    private Double calcularPrecioFinal() {
        Double descuento = 0D;
        Double precioCompra = sumatoriaCompra(comprasEducacion) + sumatoriaCompra(comprasOtros);

        descuento += sumatoriaDescuentosEducacion(comprasEducacion);
        descuento += sumatoriaDescuentoSegundoLibro(comprasOtros);

        return precioCompra - descuento;
    }

    private Double sumatoriaCompra(List<DtoCompra> compras) {
        Double sumaPrecios = 0D;

        for (DtoCompra compra: compras)
            sumaPrecios += compra.getPrecio();

        return sumaPrecios;
    }

    private Double sumatoriaDescuentosEducacion(List<DtoCompra> compras) {
        Double sum = 0D;

        for (DtoCompra compra: compras)
            sum += compra.getPrecio() * DESCUENTO_LIBRO_EDUCACION;

        return sum;
    }

    private Double sumatoriaDescuentoSegundoLibro(List<DtoCompra> compras) {
        Double sum = 0D;

        for (int i=0; i<compras.size(); i++)
            if (i % 2 != 0)
                sum += compras.get(i).getPrecio() * DESCUENTO_SEGUNDO_LIBRO;

        return sum;
    }
}
