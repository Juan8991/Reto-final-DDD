package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class ActualizarClasificacionDeRiesgoDelEquipo extends Command {
    private final HojaDeVidaId hojaDeVidaId;
    private final EquipoId equipoId;
    private final ClasificacionDelRiesgo clasificacionDelRiesgo;

    public ActualizarClasificacionDeRiesgoDelEquipo(HojaDeVidaId hojaDeVidaId, EquipoId equipoId, ClasificacionDelRiesgo clasificacionDelRiesgo) {
        this.hojaDeVidaId = hojaDeVidaId;
        this.equipoId = equipoId;
        this.clasificacionDelRiesgo = clasificacionDelRiesgo;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public EquipoId getEquipoId() {
        return equipoId;
    }

    public ClasificacionDelRiesgo getClasificacionDelRiesgo() {
        return clasificacionDelRiesgo;
    }
}
