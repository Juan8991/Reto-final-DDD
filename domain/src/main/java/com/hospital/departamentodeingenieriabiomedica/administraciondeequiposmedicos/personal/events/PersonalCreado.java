package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;

public class PersonalCreado extends DomainEvent {
    private final DatosPersonales datosPersonales;

    public PersonalCreado(DatosPersonales datosPersonales) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.PersonalCreado");
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
