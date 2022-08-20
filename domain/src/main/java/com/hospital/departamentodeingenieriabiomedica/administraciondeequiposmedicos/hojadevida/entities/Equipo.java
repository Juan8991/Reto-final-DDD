package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.RegistroInvima;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

import java.util.Objects;

public class Equipo extends Entity<EquipoId> {
    private DatosDelEquipo datosDelEquipo;
    private RegistroInvima registroInvima;
    private ClasificacionDelRiesgo clasificacionDelRiesgo;
    private Ubicacion ubicacion;

    public Equipo(EquipoId entityId, DatosDelEquipo datosDelEquipo, RegistroInvima registroInvima, ClasificacionDelRiesgo clasificacionDelRiesgo, Ubicacion ubicacion) {
        super(entityId);
        this.datosDelEquipo = datosDelEquipo;
        this.registroInvima = registroInvima;
        this.clasificacionDelRiesgo = clasificacionDelRiesgo;
        this.ubicacion = ubicacion;
    }
    public void actualizarClasificacionDeRiesgo(ClasificacionDelRiesgo clasificacionDelRiesgo){
        this.clasificacionDelRiesgo=clasificacionDelRiesgo;
    }
    public void actualizarUbicacion(Ubicacion ubicacion){
        this.ubicacion= Objects.requireNonNull(ubicacion);
    }

}
