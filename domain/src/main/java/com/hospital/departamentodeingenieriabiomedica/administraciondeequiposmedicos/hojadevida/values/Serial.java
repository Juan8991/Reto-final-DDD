package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class Serial implements ValueObject<String> {
    private final String serial;

    public Serial(String serial) {
        this.serial = serial;
    }

}
