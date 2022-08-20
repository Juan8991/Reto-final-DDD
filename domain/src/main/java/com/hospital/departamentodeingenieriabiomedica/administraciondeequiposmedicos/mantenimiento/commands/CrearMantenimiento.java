package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;

public class CrearMantenimiento extends Command {
    private final MantenimientoId mantenimientoId;
    private final Herramientas herramientas;

    public CrearMantenimiento(MantenimientoId mantenimientoId,Herramientas herramientas) {
        this.mantenimientoId = mantenimientoId;
        this.herramientas = herramientas;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }

    public Herramientas getHerramientas() {
        return herramientas;
    }
}
