package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;

public class AccesorioAsignado extends DomainEvent {
    private final AccesorioId accesorioId;
    private final DatosDelAccesorio datosDelAccesorio;

    public AccesorioAsignado( AccesorioId accesorioId, DatosDelAccesorio datosDelAccesorio) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.AccesorioAsignado");
        this.accesorioId = accesorioId;
        this.datosDelAccesorio = datosDelAccesorio;
    }

    public AccesorioId getAccesorioId() {
        return accesorioId;
    }

    public DatosDelAccesorio getDatosDelAccesorio() {
        return datosDelAccesorio;
    }
}
