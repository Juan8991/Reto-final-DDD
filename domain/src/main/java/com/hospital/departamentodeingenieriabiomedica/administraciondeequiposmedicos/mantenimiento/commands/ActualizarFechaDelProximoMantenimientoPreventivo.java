package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

public class ActualizarFechaDelProximoMantenimientoPreventivo extends Command {
    private final MantenimientoId mantenimientoId;
    private final MantenimientoPreventivoId mantenimientoPreventivoId;
    private final FechaDelProximoMantenimiento fechaDelProximoMantenimiento;

    public ActualizarFechaDelProximoMantenimientoPreventivo(MantenimientoId mantenimientoId, MantenimientoPreventivoId mantenimientoPreventivoId, FechaDelProximoMantenimiento fechaDelProximoMantenimiento) {
        this.mantenimientoId = mantenimientoId;
        this.mantenimientoPreventivoId = mantenimientoPreventivoId;
        this.fechaDelProximoMantenimiento = fechaDelProximoMantenimiento;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }

    public MantenimientoPreventivoId getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public FechaDelProximoMantenimiento getFechaDelProximoMantenimiento() {
        return fechaDelProximoMantenimiento;
    }
}
