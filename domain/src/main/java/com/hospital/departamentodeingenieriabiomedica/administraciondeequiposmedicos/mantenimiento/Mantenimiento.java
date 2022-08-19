package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.HojaDeVidaEventChange;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.ClasificacionDeRiesgoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.DescripcionDelMantenimientoCorrectivoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.DiagnosticoActualizado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.FechaDelProximoMantenimientoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;

import java.util.Objects;

public class Mantenimiento extends AggregateEvent<MantenimientoId> {
    protected MantenimientoPreventivo mantenimientoPreventivo;
    protected MantenimientoCorrectivo mantenimientoCorrectivo;

    public Mantenimiento(MantenimientoId entityId, MantenimientoPreventivo mantenimientoPreventivo, MantenimientoCorrectivo mantenimientoCorrectivo) {
        super(entityId);
        subscribe(new MantenimientoEventChange(this));
    }
    public void CrearMantenimiento( MantenimientoId entityId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo) {
        appendChange(new MantenimientoCreado(entityId)).apply();
        subscribe(new MantenimientoEventChange(this));
    }
    public void ActualizarDescripcionDelMantenimientoCorrectivo( MantenimientoCorrectivoId mantenimientoCorrectivoId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo) {
        Objects.requireNonNull(mantenimientoCorrectivoId);
        Objects.requireNonNull(descripcionDeMantenimientoCorrectivo);
        appendChange(new DescripcionDelMantenimientoCorrectivoActualizada(mantenimientoCorrectivoId,descripcionDeMantenimientoCorrectivo)).apply();
    }
    public void ActualizarDiagnosticoDelMantenimientoCorrectivo(MantenimientoCorrectivoId mantenimientoCorrectivoId, Diagnostico diagnostico) {
        Objects.requireNonNull(mantenimientoCorrectivoId);
        Objects.requireNonNull(diagnostico);
        appendChange(new DiagnosticoActualizado(mantenimientoCorrectivoId,diagnostico)).apply();
    }
    public void ActualizarFechaDelProximoMantenimientoPreventivo( MantenimientoPreventivoId mantenimientoPreventivoId, FechaDelProximoMantenimiento fechaDelProximoMantenimiento) {
        Objects.requireNonNull(mantenimientoPreventivoId);
        Objects.requireNonNull(fechaDelProximoMantenimiento);
        appendChange(new FechaDelProximoMantenimientoActualizada(mantenimientoPreventivoId,fechaDelProximoMantenimiento)).apply();
    }
    public MantenimientoPreventivo mantenimientoPreventivo(){
        return this.mantenimientoPreventivo;
    }
    public MantenimientoCorrectivo mantenimientoCorrectivo(){
        return this.mantenimientoCorrectivo;
    }


}
