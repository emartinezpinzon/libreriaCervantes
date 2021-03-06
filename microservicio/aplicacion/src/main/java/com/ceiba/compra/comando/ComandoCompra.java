package com.ceiba.compra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra {

    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaEntrega;
}
