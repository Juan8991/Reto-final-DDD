package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

public class FechaDelProximoMantenimientoActualizada extends DomainEvent {
    private final MantenimientoPreventivoId mantenimientoPreventivoId;
    private final FechaDelProximoMantenimiento fechaDelProximoMantenimiento;

    public FechaDelProximoMantenimientoActualizada(MantenimientoPreventivoId mantenimientoPreventivoId, FechaDelProximoMantenimiento fechaDelProximoMantenimiento) {
        super ("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.FechaDelProximoMantenimientoActualizada");

        this.mantenimientoPreventivoId = mantenimientoPreventivoId;
        this.fechaDelProximoMantenimiento = fechaDelProximoMantenimiento;
    }

    public MantenimientoPreventivoId getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public FechaDelProximoMantenimiento getFechaDelProximoMantenimiento() {
        return fechaDelProximoMantenimiento;
    }
}
