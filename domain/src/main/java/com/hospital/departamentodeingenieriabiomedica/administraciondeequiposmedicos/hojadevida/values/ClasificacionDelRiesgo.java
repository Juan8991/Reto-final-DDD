package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class ClasificacionDelRiesgo implements ValueObject<String> {
    private final String clasificacion;

    public ClasificacionDelRiesgo(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    @Override
    public String value() {
        return clasificacion;
    }
}
