package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDelMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

public class MantenimientoPreventivoAgregado extends DomainEvent {
    private final MantenimientoPreventivoId mantenimientoPreventivoId;
    private final DescripcionDelMantenimiento descripcionDelMantenimiento;
    private final FechaDelProximoMantenimiento fechaDelProximoMantenimiento;
    private final FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo;

    public MantenimientoPreventivoAgregado(MantenimientoPreventivoId mantenimientoPreventivoId, DescripcionDelMantenimiento descripcionDelMantenimiento, FechaDelProximoMantenimiento fechaDelProximoMantenimiento, FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.MantenimientoPreventivoAgregado");
        this.mantenimientoPreventivoId=mantenimientoPreventivoId;
        this.descripcionDelMantenimiento = descripcionDelMantenimiento;
        this.fechaDelProximoMantenimiento = fechaDelProximoMantenimiento;
        this.fechaDelMantenimientoPreventivo = fechaDelMantenimientoPreventivo;
    }

    public MantenimientoPreventivoId getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public DescripcionDelMantenimiento getDescripcionDelMantenimiento() {
        return descripcionDelMantenimiento;
    }

    public FechaDelProximoMantenimiento getFechaDelProximoMantenimiento() {
        return fechaDelProximoMantenimiento;
    }

    public FechaDelMantenimientoPreventivo getFechaDelMantenimientoPreventivo() {
        return fechaDelMantenimientoPreventivo;
    }


}
