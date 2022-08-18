package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.Identity;

public class AccesorioId extends Identity {
    public AccesorioId(String uuid) {
        super(uuid);
    }

    public AccesorioId() {
    }
    public static AccesorioId of(String uuid){
        return new AccesorioId(uuid);
    }

}
