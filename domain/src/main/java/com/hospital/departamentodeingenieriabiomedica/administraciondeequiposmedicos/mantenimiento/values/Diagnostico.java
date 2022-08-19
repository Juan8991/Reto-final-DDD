package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

public class Diagnostico implements ValueObject<String> {
    private final String diagnostico;

    public Diagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String value() {
        return diagnostico;
    }
}
