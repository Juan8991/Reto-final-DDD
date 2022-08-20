package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

public class Herramientas implements ValueObject<String> {
    private final String nombres;

    public Herramientas(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String value() {
        return nombres;
    }
}
