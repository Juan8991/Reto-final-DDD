package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class FechaDelProximoMantenimiento implements ValueObject<LocalDate> {
    private final LocalDate fecha;

    public FechaDelProximoMantenimiento(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public LocalDate value() {
        return fecha;
    }
}
