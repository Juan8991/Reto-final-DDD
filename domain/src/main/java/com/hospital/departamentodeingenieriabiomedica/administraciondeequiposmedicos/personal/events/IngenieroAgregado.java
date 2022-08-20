package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;

public class IngenieroAgregado extends DomainEvent {
    private final IngenieroBiomedicoId ingenieroBiomedicoId;
    private final PersonalACargo personalACargo;
    private final Responsabilidades responsabilidades;

    public IngenieroAgregado(IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo, Responsabilidades responsabilidades) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.IngenieroAgregado");
        this.ingenieroBiomedicoId = ingenieroBiomedicoId;
        this.personalACargo = personalACargo;
        this.responsabilidades = responsabilidades;
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
