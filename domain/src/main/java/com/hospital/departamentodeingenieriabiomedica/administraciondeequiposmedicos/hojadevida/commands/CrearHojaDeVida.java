package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;

public class CrearHojaDeVida extends Command {
    private final HojaDeVidaId hojaDeVidaId;
    private final Serial serial;

    public CrearHojaDeVida(HojaDeVidaId hojaDeVidaId, Serial serial) {

        this.hojaDeVidaId = hojaDeVidaId;
        this.serial=serial;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Serial getSerial() {
        return serial;
    }
}
