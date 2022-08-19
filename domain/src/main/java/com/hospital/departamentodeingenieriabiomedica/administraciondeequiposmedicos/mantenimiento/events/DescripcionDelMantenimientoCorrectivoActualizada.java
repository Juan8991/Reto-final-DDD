package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class DescripcionDelMantenimientoCorrectivoActualizada extends DomainEvent {

    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo;

    public DescripcionDelMantenimientoCorrectivoActualizada(MantenimientoCorrectivoId mantenimientoCorrectivoId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.DescripcionDelMantenimientoCorrectivoActualizada");

        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.descripcionDeMantenimientoCorrectivo = descripcionDeMantenimientoCorrectivo;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
    }

    public DescripcionDeMantenimientoCorrectivo getDescripcionDeMantenimientoCorrectivo() {
        return descripcionDeMantenimientoCorrectivo;
    }
}
