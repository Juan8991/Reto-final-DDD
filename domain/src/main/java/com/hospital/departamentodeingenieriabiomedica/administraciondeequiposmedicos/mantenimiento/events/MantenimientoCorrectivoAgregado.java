package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class MantenimientoCorrectivoAgregado  extends DomainEvent {
    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final Diagnostico diagnostico;
    private final DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo;
    private final FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo;


    public MantenimientoCorrectivoAgregado(MantenimientoCorrectivoId mantenimientoCorrectivoId,Diagnostico diagnostico,DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo,FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo) {
        super ("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.MantenimientoCorrectivoAgregado");
        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.diagnostico = diagnostico;
        this.descripcionDeMantenimientoCorrectivo = descripcionDeMantenimientoCorrectivo;
        this.fechaDelMantenimientoCorrectivo = fechaDelMantenimientoCorrectivo;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
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
