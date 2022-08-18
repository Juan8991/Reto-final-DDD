package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.Identity;

public class HojaDeVidaId extends Identity {
    public HojaDeVidaId(String uuid) {
        super(uuid);
    }

    public HojaDeVidaId() {
    }
    public static HojaDeVidaId of(String uuid){
        return new HojaDeVidaId(uuid);
    }
}
