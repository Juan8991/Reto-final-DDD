package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.ValueObject;

public class ResponsabilidadesTecnicas implements ValueObject<String> {
    private final String responsabilidades;

    public ResponsabilidadesTecnicas(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }
    @Override
    public String value() {
        return responsabilidades;
    }
}
