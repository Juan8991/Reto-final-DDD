package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class FechaDelMantenimientoCorrectivo implements ValueObject<LocalDate> {
    private final LocalDate fecha;

    public FechaDelMantenimientoCorrectivo(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public LocalDate value() {
        return fecha;
    }
}
