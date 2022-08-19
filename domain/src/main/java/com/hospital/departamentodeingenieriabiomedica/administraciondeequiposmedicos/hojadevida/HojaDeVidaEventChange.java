package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class HojaDeVidaEventChange extends EventChange {
    public HojaDeVidaEventChange(HojaDeVida hojaDeVida) {
        apply((HojaDeVidaCreada event) -> {
            hojaDeVida.identity().value() = event.getHojaDeVidaId();
        });

    }
}
