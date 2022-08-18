package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Accesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities.Equipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

import java.util.Set;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {
    protected Equipo equipo;
    protected Accesorio accesorio;

    public HojaDeVida(HojaDeVidaId entityId, Equipo equipo, Accesorio accesorio) {
        super(entityId);
        this.equipo = equipo;
        this.accesorio = accesorio;
    }
}
