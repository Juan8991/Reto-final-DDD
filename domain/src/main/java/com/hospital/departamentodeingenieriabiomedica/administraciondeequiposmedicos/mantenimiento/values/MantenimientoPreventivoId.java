package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.Identity;

public class MantenimientoPreventivoId extends Identity {
    public MantenimientoPreventivoId(String uuid) {
        super(uuid);
    }

    public MantenimientoPreventivoId() {
    }
    public static MantenimientoPreventivoId of(String uuid){
        return new MantenimientoPreventivoId(uuid);
    }

}
