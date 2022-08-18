package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.Identity;

public class EquipoId extends Identity {
    public EquipoId(String uuid) {
        super(uuid);
    }

    public EquipoId() {
    }
    public static EquipoId of(String uuid){
        return new EquipoId(uuid);
    }

}
