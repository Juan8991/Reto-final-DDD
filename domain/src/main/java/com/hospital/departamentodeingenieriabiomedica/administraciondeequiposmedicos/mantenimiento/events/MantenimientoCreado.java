package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class MantenimientoCreado extends DomainEvent {
    private final MantenimientoId mantenimientoId;

    public MantenimientoCreado(MantenimientoId mantenimientoId) {
        super ("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.MantenimientoCreado");
        this.mantenimientoId = mantenimientoId;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }
}
