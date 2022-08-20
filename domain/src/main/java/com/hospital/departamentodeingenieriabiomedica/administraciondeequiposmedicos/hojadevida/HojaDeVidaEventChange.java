package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Accesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Equipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.AccesorioAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.ClasificacionDeRiesgoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.DatosDelAccesorioActualizados;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.EquipoAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.UbiacionActualizada;


public class HojaDeVidaEventChange extends EventChange {
    public HojaDeVidaEventChange(HojaDeVida hojaDeVida) {
        apply((HojaDeVidaCreada event) -> {
            hojaDeVida.serial= event.getSerial();
        });
        apply((EquipoAsignado event) -> {
            hojaDeVida.equipo = new Equipo(event.getEquipoId(),event.getDatosDelEquipo(),event.getRegistroInvima(),event.getClasificacionDelRiesgo(),event.getUbicacion());
        });
        apply((AccesorioAsignado event) -> {
            hojaDeVida.accesorio = new Accesorio(event.getAccesorioId(),event.getDatosDelAccesorio());
        });
        apply((UbiacionActualizada event) -> {
            hojaDeVida.equipo.actualizarUbicacion(event.getUbicacion());
        });
        apply((ClasificacionDeRiesgoActualizada event) -> {
            hojaDeVida.equipo.actualizarClasificacionDeRiesgo(event.getClasificacionDelRiesgo());
        });
        apply((DatosDelAccesorioActualizados event) -> {
            hojaDeVida.accesorio.actualizarDatosDelAccesorio(event.getDatosDelAccesorio());
        });


    }
}
