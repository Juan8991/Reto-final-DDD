package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.RegistroInvima;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

public class AsignarEquipo extends Command {
    private final HojaDeVidaId hojaDeVidaId;
    private final EquipoId equipoId;
    private final DatosDelEquipo datosDelEquipo;
    private final RegistroInvima registroInvima;
    private final ClasificacionDelRiesgo clasificacionDelRiesgo;
    private final Ubicacion ubicacion;

    public AsignarEquipo(HojaDeVidaId hojaDeVidaId, EquipoId equipoId, DatosDelEquipo datosDelEquipo, RegistroInvima registroInvima, ClasificacionDelRiesgo clasificacionDelRiesgo, Ubicacion ubicacion) {
        this.hojaDeVidaId = hojaDeVidaId;
        this.equipoId=equipoId;
        this.datosDelEquipo = datosDelEquipo;
        this.registroInvima = registroInvima;
        this.clasificacionDelRiesgo = clasificacionDelRiesgo;
        this.ubicacion = ubicacion;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public EquipoId getEquipoId() {
        return equipoId;
    }

    public DatosDelEquipo getDatosDelEquipo() {
        return datosDelEquipo;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }

    public ClasificacionDelRiesgo getClasificacionDelRiesgo() {
        return clasificacionDelRiesgo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
