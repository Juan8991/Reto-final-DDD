package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

public class ActualizarResponsabilidadesDelTecnicoBiomedico extends Command {
    private final PersonalId personalId;
    private final TecnicoBiomedicoId tecnicoBiomedicoId;
    private final ResponsabilidadesTecnicas responsabilidades;

    public ActualizarResponsabilidadesDelTecnicoBiomedico(PersonalId personalId, TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidades) {
        this.personalId = personalId;
        this.tecnicoBiomedicoId = tecnicoBiomedicoId;
        this.responsabilidades = responsabilidades;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public TecnicoBiomedicoId getTecnicoBiomedicoId() {
        return tecnicoBiomedicoId;
    }

    public ResponsabilidadesTecnicas getResponsabilidades() {
        return responsabilidades;
    }
}
