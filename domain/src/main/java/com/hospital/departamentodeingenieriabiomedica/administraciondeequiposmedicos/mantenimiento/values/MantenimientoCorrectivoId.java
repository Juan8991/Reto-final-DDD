package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.Identity;

public class MantenimientoCorrectivoId extends Identity {
    public MantenimientoCorrectivoId(String uuid) {
        super(uuid);
    }

    public MantenimientoCorrectivoId() {
    }
    public static MantenimientoCorrectivoId of(String uuid){
        return new MantenimientoCorrectivoId(uuid);
    }

}
