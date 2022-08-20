package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;

public class PersonalACargoActualizado extends DomainEvent {
    private final IngenieroBiomedicoId ingenieroBiomedicoId;
    private final PersonalACargo personalACargo;

    public PersonalACargoActualizado(IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.PersonalACargoActualizado");
        this.ingenieroBiomedicoId = ingenieroBiomedicoId;
        this.personalACargo = personalACargo;
    }

    public IngenieroBiomedicoId getIngenieroBiomedicoId() {
        return ingenieroBiomedicoId;
    }

    public PersonalACargo getPersonalACargo() {
        return personalACargo;
    }
}
