package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

public class DescripcionDelMantenimiento implements ValueObject<String> {
    private final String descripcion;

    public DescripcionDelMantenimiento(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String value() {
        return descripcion;
    }
}
