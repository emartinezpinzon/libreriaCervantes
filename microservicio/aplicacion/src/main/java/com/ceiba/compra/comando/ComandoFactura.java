package com.ceiba.compra.comando;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {

    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;
}
