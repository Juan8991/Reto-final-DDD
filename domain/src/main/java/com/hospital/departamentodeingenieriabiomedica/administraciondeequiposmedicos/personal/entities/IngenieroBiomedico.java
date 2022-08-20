package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;

import java.util.Objects;

public class IngenieroBiomedico extends Entity<IngenieroBiomedicoId> {
    private PersonalACargo personalACargo;
    private Responsabilidades responsabilidades;

    public IngenieroBiomedico(IngenieroBiomedicoId entityId, PersonalACargo personalACargo, Responsabilidades responsabilidades) {
        super(entityId);
        this.personalACargo = personalACargo;
        this.responsabilidades = responsabilidades;
    }
    public void actualizarPersonalAcargo(PersonalACargo personalACargo){
        this.personalACargo = Objects.requireNonNull(personalACargo);
    }
}
