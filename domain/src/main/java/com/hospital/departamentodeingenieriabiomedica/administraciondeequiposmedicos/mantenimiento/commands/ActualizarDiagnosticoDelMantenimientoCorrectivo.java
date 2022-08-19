package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class ActualizarDiagnosticoDelMantenimientoCorrectivo extends Command {
    private final MantenimientoId mantenimientoId;
    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final Diagnostico diagnostico;

    public ActualizarDiagnosticoDelMantenimientoCorrectivo(MantenimientoId mantenimientoId, MantenimientoCorrectivoId mantenimientoCorrectivoId, Diagnostico diagnostico) {
        this.mantenimientoId = mantenimientoId;
        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.diagnostico = diagnostico;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
