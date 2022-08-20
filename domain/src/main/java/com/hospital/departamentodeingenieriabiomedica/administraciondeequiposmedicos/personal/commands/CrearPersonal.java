package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;

public class CrearPersonal extends Command {
    private final PersonalId personalId;
    private final DatosPersonales datosPersonales;

    public CrearPersonal(PersonalId personalId, DatosPersonales datosPersonales) {
        this.personalId = personalId;
        this.datosPersonales = datosPersonales;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
