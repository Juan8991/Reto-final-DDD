package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class DatosDelAccesorioActualizados extends DomainEvent {

    private final DatosDelAccesorio datosDelAccesorio;

    public DatosDelAccesorioActualizados( DatosDelAccesorio datosDelAccesorio) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.DatosDelAccesorioActualizados");
        this.datosDelAccesorio = datosDelAccesorio;
    }

    public DatosDelAccesorio getDatosDelAccesorio() {
        return datosDelAccesorio;
    }
}
