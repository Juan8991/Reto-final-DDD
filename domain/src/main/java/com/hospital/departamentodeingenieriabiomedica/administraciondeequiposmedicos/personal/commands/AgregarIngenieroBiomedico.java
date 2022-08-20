package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;

public class AgregarIngenieroBiomedico extends Command {
    private final PersonalId personalId;
    private final IngenieroBiomedicoId ingenieroBiomedicoId;
    private final PersonalACargo personalACargo;
    private final Responsabilidades responsabilidades;

    public AgregarIngenieroBiomedico(PersonalId personalId, IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo, Responsabilidades responsabilidades) {
        this.personalId = personalId;
        this.ingenieroBiomedicoId = ingenieroBiomedicoId;
        this.personalACargo = personalACargo;
        this.responsabilidades = responsabilidades;
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

    public Responsabilidades getResponsabilidades() {
        return responsabilidades;
    }
}
