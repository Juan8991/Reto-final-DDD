package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Accesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Equipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.ClasificacionDeRiesgoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.DatosDelAccesorioActualizados;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.UbiacionActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

import java.util.List;
import java.util.Objects;


public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {
    protected Equipo equipo;
    protected Accesorio accesorio;

    public HojaDeVida(HojaDeVidaId entityId) {
        super(entityId);
        subscribe(new HojaDeVidaEventChange(this));
    }
    public void CrearHojaDeVida(HojaDeVidaId hojaDeVidaId){
        appendChange(new HojaDeVidaCreada(hojaDeVidaId)).apply();
        subscribe(new HojaDeVidaEventChange(this));
    }
    public static HojaDeVida from(HojaDeVidaId entityId, List<DomainEvent> events) {
        var hojaDeVida = new HojaDeVida(entityId);
        events.forEach(hojaDeVida::applyEvent);
        return hojaDeVida;
    }
    public void ActualizarClasificacionDeRiesgoDelEquipo(EquipoId equipoId, ClasificacionDelRiesgo clasificacionDelRiesgo){
        Objects.requireNonNull(equipoId);
        Objects.requireNonNull(clasificacionDelRiesgo);
        appendChange(new ClasificacionDeRiesgoActualizada(equipoId,clasificacionDelRiesgo)).apply();
    }
    public void ActualizarDatosDelAccesorio(AccesorioId accesorioId, DatosDelAccesorio datosDelAccesorio){
        Objects.requireNonNull(accesorioId);
        Objects.requireNonNull(datosDelAccesorio);
        appendChange(new DatosDelAccesorioActualizados(accesorioId,datosDelAccesorio)).apply();
    }
    public void ActualizarUbicacionDelEquipo( EquipoId equipoId, Ubicacion ubicacion){
        Objects.requireNonNull(equipoId);
        Objects.requireNonNull(ubicacion);
        appendChange(new UbiacionActualizada(equipoId,ubicacion)).apply();
    }
    public Equipo equipo(){
        return this.equipo;
    }
    public Accesorio accesorio(){
        return this.accesorio;
    }
}
