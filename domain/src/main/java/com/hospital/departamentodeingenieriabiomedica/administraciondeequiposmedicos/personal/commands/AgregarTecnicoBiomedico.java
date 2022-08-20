package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

public class AgregarTecnicoBiomedico extends Command {
    private final PersonalId personalId;
    private final TecnicoBiomedicoId tecnicoBiomedicoId;
    private final ResponsabilidadesTecnicas responsabilidadesTecnicas;

    public AgregarTecnicoBiomedico(PersonalId personalId, TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidadesTecnicas) {
        this.personalId = personalId;
        this.tecnicoBiomedicoId = tecnicoBiomedicoId;
        this.responsabilidadesTecnicas = responsabilidadesTecnicas;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public TecnicoBiomedicoId getTecnicoBiomedicoId() {
        return tecnicoBiomedicoId;
    }

    public ResponsabilidadesTecnicas getResponsabilidadesTecnicas() {
        return responsabilidadesTecnicas;
    }
}
