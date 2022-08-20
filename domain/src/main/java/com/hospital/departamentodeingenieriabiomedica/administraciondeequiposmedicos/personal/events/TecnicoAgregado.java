package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

public class TecnicoAgregado extends DomainEvent {
    private final TecnicoBiomedicoId tecnicoBiomedicoId;
    private final ResponsabilidadesTecnicas responsabilidadesTecnicas;

    public TecnicoAgregado(TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidadesTecnicas) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.TecnicoAgregado");
        this.tecnicoBiomedicoId = tecnicoBiomedicoId;
        this.responsabilidadesTecnicas = responsabilidadesTecnicas;
    }

    public TecnicoBiomedicoId getTecnicoBiomedicoId() {
        return tecnicoBiomedicoId;
    }

    public ResponsabilidadesTecnicas getResponsabilidadesTecnicas() {
        return responsabilidadesTecnicas;
    }
}
