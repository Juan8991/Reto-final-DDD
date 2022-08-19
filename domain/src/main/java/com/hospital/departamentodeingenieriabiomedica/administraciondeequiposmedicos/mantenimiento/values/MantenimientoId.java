package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values;

import co.com.sofka.domain.generic.Identity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class MantenimientoId extends Identity {
    public MantenimientoId(String uuid) {
        super(uuid);
    }

    public MantenimientoId() {
    }
    public static MantenimientoId of(String uuid){
        return new MantenimientoId(uuid);
    }
}
