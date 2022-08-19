package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class DiagnosticoActualizado extends DomainEvent {
    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final Diagnostico diagnostico;

    public DiagnosticoActualizado(MantenimientoCorrectivoId mantenimientoCorrectivoId, Diagnostico diagnostico) {
        super ("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.DiagnosticoActualizado");
        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.diagnostico = diagnostico;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
