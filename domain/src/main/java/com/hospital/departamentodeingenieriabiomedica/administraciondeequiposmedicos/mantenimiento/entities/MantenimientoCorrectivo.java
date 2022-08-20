package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;

import java.util.Objects;

public class MantenimientoCorrectivo extends Entity<MantenimientoCorrectivoId> {
    private Diagnostico diagnostico;
    private DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo;
    private FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo;

    public MantenimientoCorrectivo(MantenimientoCorrectivoId entityId, Diagnostico diagnostico, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo, FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo) {
        super(entityId);
        this.diagnostico = diagnostico;
        this.descripcionDeMantenimientoCorrectivo = descripcionDeMantenimientoCorrectivo;
        this.fechaDelMantenimientoCorrectivo = Objects.requireNonNull(fechaDelMantenimientoCorrectivo);
    }
    public void actualizarDiagnostico( Diagnostico diagnostico){
        this.diagnostico=diagnostico;
    }
    public void actualizarDescripcionDelMantenimientoCorrectivo(DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo){
        this.descripcionDeMantenimientoCorrectivo= Objects.requireNonNull(descripcionDeMantenimientoCorrectivo);
    }

}
