package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Accesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Equipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.AccesorioAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.ClasificacionDeRiesgoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.DatosDelAccesorioActualizados;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.EquipoAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.UbiacionActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.RegistroInvima;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

import java.util.List;
import java.util.Objects;


public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {
    protected Equipo equipo;
    protected Accesorio accesorio;
    protected Serial serial;

    public HojaDeVida(HojaDeVidaId entityId) {
        super(entityId);
        subscribe(new HojaDeVidaEventChange(this));
    }
    public HojaDeVida(HojaDeVidaId entityId,Serial serial){
        super(entityId);
        appendChange(new HojaDeVidaCreada(serial)).apply();
        subscribe(new HojaDeVidaEventChange(this));
    }
    public static HojaDeVida from(HojaDeVidaId entityId,List<DomainEvent> events) {
        HojaDeVida hojaDeVida = new HojaDeVida(entityId);
        events.forEach(hojaDeVida::applyEvent);
        return hojaDeVida;
    }
    public void actualizarClasificacionDeRiesgoDelEquipo(EquipoId equipoId, ClasificacionDelRiesgo clasificacionDelRiesgo){
        Objects.requireNonNull(equipoId);
        Objects.requireNonNull(clasificacionDelRiesgo);
        appendChange(new ClasificacionDeRiesgoActualizada(equipoId,clasificacionDelRiesgo)).apply();
    }
    public void actualizarDatosDelAccesorio( DatosDelAccesorio datosDelAccesorio){
        Objects.requireNonNull(datosDelAccesorio);
        appendChange(new DatosDelAccesorioActualizados(datosDelAccesorio)).apply();
    }
    public void actualizarUbicacionDelEquipo( EquipoId equipoId, Ubicacion ubicacion){
        Objects.requireNonNull(equipoId);
        Objects.requireNonNull(ubicacion);
        appendChange(new UbiacionActualizada(equipoId,ubicacion)).apply();
    }
    public void asignarEquipo(EquipoId equipoId,DatosDelEquipo datosDelEquipo, RegistroInvima registroInvima,ClasificacionDelRiesgo clasificacionDelRiesgo,Ubicacion ubicacion ){
        Objects.requireNonNull(equipoId);
        Objects.requireNonNull(registroInvima);
        Objects.requireNonNull(clasificacionDelRiesgo);
        Objects.requireNonNull(ubicacion);
        appendChange(new EquipoAsignado(equipoId,datosDelEquipo,registroInvima,clasificacionDelRiesgo,ubicacion)).apply();
    }
    public void asignarAccesorio(AccesorioId accesorioId,DatosDelAccesorio datosDelAccesorio){
        Objects.requireNonNull(accesorioId);
        Objects.requireNonNull(datosDelAccesorio);
        appendChange(new AccesorioAsignado(accesorioId,datosDelAccesorio)).apply();
    }
    public Equipo equipo(){
        return this.equipo;
    }
    public Accesorio accesorio(){
        return this.accesorio;
    }
    public Serial serial(){
        return this.serial;
    }
}
