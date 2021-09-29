package com.ceiba.dominio.excepcion;

public class ExcepcionNoRegistrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionNoRegistrado(String mensaje) {
        super(mensaje);
    }
}
