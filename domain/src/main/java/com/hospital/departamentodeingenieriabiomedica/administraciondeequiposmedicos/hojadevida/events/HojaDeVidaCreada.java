package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class HojaDeVidaCreada extends DomainEvent {
    private final HojaDeVidaId hojaDeVidaId;

    public HojaDeVidaCreada(HojaDeVidaId hojaDeVidaId) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.HojaDeVidaCreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }
    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
