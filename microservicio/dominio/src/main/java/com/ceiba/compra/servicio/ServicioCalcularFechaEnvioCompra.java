package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCalcularFechaEnvioCompra {

    private static final String DISTRIBUCION_NACIONAL = "Nacional";
    private static final int ESPERA_ENVIO_NACIONAL = 3;
    private static final int ESPERA_ENVIO_INTERNACIONAL = 5;

    private final DtoCompra dtoCompra;

    public ServicioCalcularFechaEnvioCompra(DtoCompra dtoCompra) {
        this.dtoCompra = dtoCompra;
    }

    public LocalDateTime ejecutar() {
        LocalDateTime fechaEntrega = LocalDateTime.now();

        if (dtoCompra.getCantidad() > dtoCompra.getDisponibles()) {
            fechaEntrega = calcularFechaEntrega(dtoCompra, fechaEntrega);
        }

        return fechaEntrega;
    }

    /**
     * Calcula la fecha de entrega
     *
     * @param fechaEntrega
     * @return un LocalDateTime
     */
    public LocalDateTime calcularFechaEntrega(DtoCompra dtoCompra, LocalDateTime fechaEntrega) {
        if (dtoCompra.getDistribucion().equals(DISTRIBUCION_NACIONAL))
            return validarDiaVigente(fechaEntrega, ESPERA_ENVIO_NACIONAL);

        return validarDiaVigente(fechaEntrega, ESPERA_ENVIO_INTERNACIONAL);
    }

    /**
     * SI aún no son las 9 AM del día en curso resta un día al tiempo de espera
     *
     * @param fechaEntrega
     * @param dias
     * @return un LocalDateTime
     */
    private LocalDateTime validarDiaVigente(LocalDateTime fechaEntrega, int dias) {
        if (fechaEntrega.getHour() < 9)
            return sumarDiasSinFinesDeSemana(fechaEntrega, dias-1);

        return sumarDiasSinFinesDeSemana(fechaEntrega, dias);
    }

    /**
     * Suma n días a la fecha actual sin contar sábados y domingos
     *
     * @param dias
     * @return un LocalDate con la fecha
     */
    private LocalDateTime sumarDiasSinFinesDeSemana(LocalDateTime fechaActual, int dias) {
        int diasAgregados = 0;

        while (diasAgregados < dias) {
            fechaActual = fechaActual.plusDays(1);
            if (!(fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    fechaActual.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }
        return fechaActual;
    }
}
