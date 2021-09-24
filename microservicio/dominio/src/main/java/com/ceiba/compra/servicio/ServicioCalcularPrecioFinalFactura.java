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
        List<DtoCompra> compras = daoCompra.listar();
        List<DtoCompra> comprasEducacion = new ArrayList<>();
        List<DtoCompra> comprasOtros = new ArrayList<>();

        for (DtoCompra compra: compras)
            if (compra.getCategoria().equals(CATEGORIA_LIBRO_EDUCACION))
                comprasEducacion.add(compra);
            else
                comprasOtros.add(compra);

        return calcularPrecioFinal(comprasEducacion, comprasOtros);
    }

    /**
     * Calcula el precio final de las compras con descuentos
     *
     * @param educacion
     * @param otros
     * @return un Double
     */
    public Double calcularPrecioFinal(List<DtoCompra> educacion, List<DtoCompra> otros) {
        Double descuento = 0D;
        Double precioCompra = sumatoriaCompra(educacion) + sumatoriaCompra(otros);

        descuento += sumatoriaDescuentosEducacion(educacion);
        descuento += sumatoriaDescuentoSegundoLibro(otros);

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
     * @param compras
     * @return un doble
     */
    private Double sumatoriaDescuentosEducacion(List<DtoCompra> compras) {
        Double sum = 0D;

        for (DtoCompra compra: compras)
            sum += compra.getPrecio() * DESCUENTO_LIBRO_EDUCACION;

        return sum;
    }

    /**
     * Calcula la sumatoria del descuento del segundo libro de categorías diferentes a la educación
     *
     * @param compras
     * @return un doble con la sumatoria del descuento de segundo libro
     */
    private Double sumatoriaDescuentoSegundoLibro(List<DtoCompra> compras) {
        Double sum = 0D;

        for (int i=0; i<compras.size(); i++)
            if (i % 2 != 0)
                sum += compras.get(i).getPrecio() * DESCUENTO_SEGUNDO_LIBRO;

        return sum;
    }
}
