package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;

public class MantenimientoCreado extends DomainEvent {
    private final Herramientas herramientas;

    public MantenimientoCreado(Herramientas herramientas) {
        super ("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.MantenimientoCreado");
        this.herramientas = herramientas;
    }

    public Herramientas getHerramientas() {
        return herramientas;
    }
}
