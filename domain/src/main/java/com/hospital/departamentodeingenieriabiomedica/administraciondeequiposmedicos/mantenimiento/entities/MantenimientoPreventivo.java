package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDelMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

import java.util.Objects;

public class MantenimientoPreventivo extends Entity<MantenimientoPreventivoId> {
    private DescripcionDelMantenimiento descripcionDelMantenimiento;
    private FechaDelProximoMantenimiento fechaDelProximoMantenimiento;
    private FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo;

    public MantenimientoPreventivo(MantenimientoPreventivoId entityId, DescripcionDelMantenimiento descripcionDelMantenimiento, FechaDelProximoMantenimiento fechaDelProximoMantenimiento, FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo) {
        super(entityId);
        this.descripcionDelMantenimiento = descripcionDelMantenimiento;
        this.fechaDelProximoMantenimiento = fechaDelProximoMantenimiento;
        this.fechaDelMantenimientoPreventivo = fechaDelMantenimientoPreventivo;
    }
    public void actualizarFechaDelProximoMantenimientoPreventivo(FechaDelProximoMantenimiento fechaDelProximoMantenimiento){
        this.fechaDelProximoMantenimiento= Objects.requireNonNull(fechaDelProximoMantenimiento);
    }




}
