package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDelMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

public class AgregarMantenimientoPreventivo extends Command {
    private final MantenimientoId mantenimientoId;
    private final MantenimientoPreventivoId mantenimientoPreventivoId;
    private final DescripcionDelMantenimiento descripcionDelMantenimiento;
    private final FechaDelProximoMantenimiento fechaDelProximoMantenimiento;
    private final FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo;

    public AgregarMantenimientoPreventivo(MantenimientoId mantenimientoId, MantenimientoPreventivoId mantenimientoPreventivoId, DescripcionDelMantenimiento descripcionDelMantenimiento, FechaDelProximoMantenimiento fechaDelProximoMantenimiento, FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo) {
        this.mantenimientoId = mantenimientoId;
        this.mantenimientoPreventivoId=mantenimientoPreventivoId;
        this.descripcionDelMantenimiento = descripcionDelMantenimiento;
        this.fechaDelProximoMantenimiento = fechaDelProximoMantenimiento;
        this.fechaDelMantenimientoPreventivo = fechaDelMantenimientoPreventivo;
    }

    public MantenimientoPreventivoId getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
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
