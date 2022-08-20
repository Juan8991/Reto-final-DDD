package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;

public class ActualizarPersonalACargoDelIngenieroBiomedico extends Command {
    private final PersonalId personalId;
    private final IngenieroBiomedicoId ingenieroBiomedicoId;
    private final PersonalACargo personalACargo;

    public ActualizarPersonalACargoDelIngenieroBiomedico(PersonalId personalId, IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo) {
        this.personalId = personalId;
        this.ingenieroBiomedicoId = ingenieroBiomedicoId;
        this.personalACargo = personalACargo;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public IngenieroBiomedicoId getIngenieroBiomedicoId() {
        return ingenieroBiomedicoId;
    }

    public PersonalACargo getPersonalACargo() {
        return personalACargo;
    }
}
