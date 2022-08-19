package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.Mantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;

public class ActualizarDescripcionDelMantenimientoCorrectivo extends Command {
    private final MantenimientoId mantenimientoId;
    private final MantenimientoCorrectivoId mantenimientoCorrectivoId;
    private final DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo;

    public ActualizarDescripcionDelMantenimientoCorrectivo(MantenimientoId mantenimientoId, MantenimientoCorrectivoId mantenimientoCorrectivoId, DescripcionDeMantenimientoCorrectivo descripcionDeMantenimientoCorrectivo) {
        this.mantenimientoId = mantenimientoId;
        this.mantenimientoCorrectivoId = mantenimientoCorrectivoId;
        this.descripcionDeMantenimientoCorrectivo = descripcionDeMantenimientoCorrectivo;
    }

    public MantenimientoId getMantenimientoId() {
        return mantenimientoId;
    }

    public MantenimientoCorrectivoId getMantenimientoCorrectivoId() {
        return mantenimientoCorrectivoId;
    }

    public DescripcionDeMantenimientoCorrectivo getDescripcionDeMantenimientoCorrectivo() {
        return descripcionDeMantenimientoCorrectivo;
    }
}
