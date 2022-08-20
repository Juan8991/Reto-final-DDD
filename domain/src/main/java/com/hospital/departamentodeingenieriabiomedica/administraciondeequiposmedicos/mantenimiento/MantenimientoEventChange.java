package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.entities.MantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.DescripcionDelMantenimientoCorrectivoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.FechaDelProximoMantenimientoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCorrectivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoPreventivoAgregado;

public class MantenimientoEventChange extends EventChange {
    public MantenimientoEventChange(Mantenimiento mantenimiento) {
        apply((MantenimientoCreado event) -> {
            mantenimiento.herramientas=event.getHerramientas();
        });
        apply((MantenimientoPreventivoAgregado event) -> {
            mantenimiento.mantenimientoPreventivo = new MantenimientoPreventivo(event.getMantenimientoPreventivoId(),event.getDescripcionDelMantenimiento(),event.getFechaDelProximoMantenimiento(),event.getFechaDelMantenimientoPreventivo());
        });
        apply((MantenimientoCorrectivoAgregado event) -> {
            mantenimiento.mantenimientoCorrectivo = new MantenimientoCorrectivo(event.getMantenimientoCorrectivoId(),event.getDiagnostico(),event.getDescripcionDeMantenimientoCorrectivo(),event.getFechaDelMantenimientoCorrectivo());
        });
        apply((FechaDelProximoMantenimientoActualizada event) -> {
            mantenimiento.mantenimientoPreventivo.actualizarFechaDelProximoMantenimientoPreventivo(event.getFechaDelProximoMantenimiento());
        });
        apply((DescripcionDelMantenimientoCorrectivoActualizada event) -> {
            mantenimiento.mantenimientoCorrectivo.actualizarDescripcionDelMantenimientoCorrectivo(event.getDescripcionDeMantenimientoCorrectivo());
        });
    }
}
