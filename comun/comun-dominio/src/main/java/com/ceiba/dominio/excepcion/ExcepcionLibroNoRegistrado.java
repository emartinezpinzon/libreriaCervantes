package com.ceiba.dominio.excepcion;

public class ExcepcionLibroNoRegistrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionLibroNoRegistrado(String mensaje) {
        super(mensaje);
    }
}
