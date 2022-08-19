package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

public class ActualizarUbicacionDelEquipo extends Command {
    private final HojaDeVidaId hojaDeVidaId;
    private final EquipoId equipoId;
    private final Ubicacion ubicacion;

    public ActualizarUbicacionDelEquipo(HojaDeVidaId hojaDeVidaId, EquipoId equipoId, Ubicacion ubicacion) {
        this.hojaDeVidaId = hojaDeVidaId;
        this.equipoId = equipoId;
        this.ubicacion = ubicacion;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
    public EquipoId getEquipoId() {
        return equipoId;
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
