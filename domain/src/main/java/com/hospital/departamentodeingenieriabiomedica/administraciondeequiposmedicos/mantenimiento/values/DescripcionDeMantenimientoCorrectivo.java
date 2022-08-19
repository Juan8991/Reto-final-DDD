package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

public class DescripcionDeMantenimientoCorrectivo implements ValueObject<String> {
    private final String descripcion;

    public DescripcionDeMantenimientoCorrectivo(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String value() {
        return descripcion;
    }
}
