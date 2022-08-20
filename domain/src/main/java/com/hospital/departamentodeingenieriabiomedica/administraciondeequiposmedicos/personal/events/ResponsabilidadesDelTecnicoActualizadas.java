package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

public class ResponsabilidadesDelTecnicoActualizadas extends DomainEvent {
    private final TecnicoBiomedicoId tecnicoBiomedicoId;
    private final ResponsabilidadesTecnicas responsabilidades;

    public ResponsabilidadesDelTecnicoActualizadas(TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidades) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.ResponsabilidadesDelTecnicoActualizadas");
        this.tecnicoBiomedicoId = tecnicoBiomedicoId;
        this.responsabilidades = responsabilidades;
    }


    public TecnicoBiomedicoId getTecnicoBiomedicoId() {
        return tecnicoBiomedicoId;
    }

    public ResponsabilidadesTecnicas getResponsabilidades() {
        return responsabilidades;
    }
}
