package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class CrearMantenimiento extends Command {
    private final MantenimientoId mantenimientoId;

    public CrearMantenimiento(MantenimientoId mantenimientoId) {
        this.mantenimientoId = mantenimientoId;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }
}
