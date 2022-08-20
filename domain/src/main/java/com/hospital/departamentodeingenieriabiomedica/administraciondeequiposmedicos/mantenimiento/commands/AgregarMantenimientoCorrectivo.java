package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class AgregarMantenimientoCorrectivo extends Command {
    private final MantenimientoId mantenimientoId;

    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final Diagnostico diagnostico;
    private final DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo;
    private final FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo;

    public AgregarMantenimientoCorrectivo(MantenimientoId mantenimientoId,MantenimientoCorrectivoId mantenimientoCorrectivoId, Diagnostico diagnostico, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo, FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo) {
        this.mantenimientoId = mantenimientoId;
        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.diagnostico = diagnostico;
        this.descripcionDeMantenimientoCorrectivo = descripcionDeMantenimientoCorrectivo;
        this.fechaDelMantenimientoCorrectivo = fechaDelMantenimientoCorrectivo;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public DescripcionDeMantenimientoCorrectivo getDescripcionDeMantenimientoCorrectivo() {
        return descripcionDeMantenimientoCorrectivo;
    }

    public FechaDelMantenimientoCorrectivo getFechaDelMantenimientoCorrectivo() {
        return fechaDelMantenimientoCorrectivo;
    }
}
