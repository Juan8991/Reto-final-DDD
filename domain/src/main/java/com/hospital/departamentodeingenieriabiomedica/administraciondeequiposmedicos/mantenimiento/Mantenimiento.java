package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.DescripcionDelMantenimientoCorrectivoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.FechaDelProximoMantenimientoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCorrectivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoPreventivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDelMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;

import java.util.List;
import java.util.Objects;

public class Mantenimiento extends AggregateEvent<MantenimientoId> {
    protected MantenimientoPreventivo mantenimientoPreventivo;
    protected MantenimientoCorrectivo mantenimientoCorrectivo;
    protected Herramientas herramientas;

    public Mantenimiento(MantenimientoId entityId, Herramientas herramientas) {
        super(entityId);
        appendChange(new MantenimientoCreado(herramientas)).apply();
        subscribe(new MantenimientoEventChange(this));
    }
    public Mantenimiento(MantenimientoId mantenimientoId){
        super(mantenimientoId);
    }
    public static Mantenimiento from(MantenimientoId entityId,  List<DomainEvent> events) {
        var mantenimiento = new Mantenimiento(entityId);
        events.forEach(mantenimiento::applyEvent);
        return mantenimiento;
    }
    public void agregarMantenimientoPreventivo(MantenimientoPreventivoId mantenimientoPreventivoId, DescripcionDelMantenimiento descripcionDelMantenimiento, FechaDelProximoMantenimiento fechaDelProximoMantenimiento, FechaDelMantenimientoPreventivo fechaDelMantenimientoPreventivo){
        Objects.requireNonNull(mantenimientoPreventivoId);
        Objects.requireNonNull(descripcionDelMantenimiento);
        Objects.requireNonNull(fechaDelProximoMantenimiento);
        Objects.requireNonNull(fechaDelMantenimientoPreventivo);
        appendChange(new MantenimientoPreventivoAgregado(mantenimientoPreventivoId,descripcionDelMantenimiento,fechaDelProximoMantenimiento,fechaDelMantenimientoPreventivo)).apply();

    }
    public void agregarMantenimientoCorrectivo(MantenimientoCorrectivoId mantenimientoCorrectivoId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo, FechaDelMantenimientoCorrectivo fechaDelMantenimientoCorrectivo,Diagnostico diagnostico){
        Objects.requireNonNull(mantenimientoCorrectivoId);
        Objects.requireNonNull(descripcionDeMantenimientoCorrectivo);
        Objects.requireNonNull(fechaDelMantenimientoCorrectivo);
        Objects.requireNonNull(diagnostico);
        appendChange(new MantenimientoCorrectivoAgregado(mantenimientoCorrectivoId,diagnostico,descripcionDeMantenimientoCorrectivo,fechaDelMantenimientoCorrectivo)).apply();
    }
    public void actualizarDescripcionDelMantenimientoCorrectivo( MantenimientoCorrectivoId mantenimientoCorrectivoId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo) {
        Objects.requireNonNull(mantenimientoCorrectivoId);
        Objects.requireNonNull(descripcionDeMantenimientoCorrectivo);
        appendChange(new DescripcionDelMantenimientoCorrectivoActualizada(mantenimientoCorrectivoId,descripcionDeMantenimientoCorrectivo)).apply();
    }

    public void actualizarFechaDelProximoMantenimientoPreventivo( MantenimientoPreventivoId mantenimientoPreventivoId, FechaDelProximoMantenimiento fechaDelProximoMantenimiento) {
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
    public Herramientas herramientas(){
        return this.herramientas;
    }

}
