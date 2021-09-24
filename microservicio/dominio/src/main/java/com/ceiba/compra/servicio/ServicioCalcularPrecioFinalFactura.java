package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;

import java.util.ArrayList;
import java.util.List;

public class ServicioCalcularPrecioFinalFactura {

    private static final String CATEGORIA_LIBRO_EDUCACION = "Educación";
    private static final float DESCUENTO_LIBRO_EDUCACION = 0.2F;
    private static final float DESCUENTO_SEGUNDO_LIBRO = 0.5F;

    private final DaoCompra daoCompra;

    public ServicioCalcularPrecioFinalFactura(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    /**
     * Realiza las operaciones para calcular el precio final de la compra
     *
     * @return el precio final
     */
    public Double ejecutar() {
        Double descuento = 0D;
        List<DtoCompra> compras = daoCompra.listar();
        List<DtoCompra> comprasNoEducacion = new ArrayList<>();
        Double precioCompra = sumatoriaCompra(compras);

        for (DtoCompra compra: compras)
            if (compra.getCategoria().equals(CATEGORIA_LIBRO_EDUCACION))
                descuento += calcularDescuentosEducacion(compra);
            else
                comprasNoEducacion.add(compra);

        List<Double> precios = obtenerListadoPreciosDescendenteNoEducacion(comprasNoEducacion);
        descuento += sumatoriaDescuentoSegundoLibro(precios);

        return precioCompra - descuento;
    }

    /**
     * Calcula la sumatoria de toda la compra
     *
     * @param compras
     * @return un doble
     */
    private Double sumatoriaCompra(List<DtoCompra> compras) {
        Double sumaPrecios = 0D;

        for (DtoCompra compra: compras)
            sumaPrecios += compra.getPrecio();

        return sumaPrecios;
    }

    /**
     * Calcula el descuento de educación
     *
     * @param compra
     * @return un doble
     */
    private Double calcularDescuentosEducacion(DtoCompra compra) {
        return compra.getPrecio() * DESCUENTO_LIBRO_EDUCACION;
    }

    /**
     * Obtiene el listado de precios de libros no educación de forma descendente
     *
     * @param compras
     * @return una lista ordenada de precios
     */
    private List<Double> obtenerListadoPreciosDescendenteNoEducacion(List<DtoCompra> compras) {
        List<Double> precios = new ArrayList<>();

        for (DtoCompra compra: compras)
            for (int i=0; i<compra.getCantidad(); i++)
                precios.add(compra.getPrecio());

        return precios;
    }

    /**
     * Calcula la sumatoria del descuento del segundo libro de categorías diferentes a la educación
     *
     * @param precios
     * @return un doble con la sumatoria del descuento de segundo libro
     */
    private Double sumatoriaDescuentoSegundoLibro(List<Double> precios) {
        Double sum = 0D;

        for (int i=0; i<precios.size(); i++)
            if (i % 2 == 0)
                sum += precios.get(i) * DESCUENTO_SEGUNDO_LIBRO;

        return sum;
    }
}
