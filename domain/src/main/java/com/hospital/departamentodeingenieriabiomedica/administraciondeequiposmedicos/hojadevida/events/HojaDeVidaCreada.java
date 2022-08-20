package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;

public class HojaDeVidaCreada extends DomainEvent {
    private final Serial serial;

    public HojaDeVidaCreada(Serial serial) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.HojaDeVidaCreada");
        this.serial = serial;
    }

    public Serial getSerial() {
        return serial;
    }
}
