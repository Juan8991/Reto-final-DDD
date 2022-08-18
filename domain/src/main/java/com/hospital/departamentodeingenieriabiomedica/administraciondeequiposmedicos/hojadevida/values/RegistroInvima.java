package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class RegistroInvima implements ValueObject<String> {
    private final String numeroDelRegistroInvima;

    public RegistroInvima(String numeroDelRegistroInvima) {
        this.numeroDelRegistroInvima = numeroDelRegistroInvima;
    }

    @Override
    public String value() {
        return numeroDelRegistroInvima;
    }
}
