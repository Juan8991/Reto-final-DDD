package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class Ubicacion implements ValueObject<String> {
    private final String ubicacion;

    public Ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Override
    public String value() {
        return ubicacion;
    }
}
