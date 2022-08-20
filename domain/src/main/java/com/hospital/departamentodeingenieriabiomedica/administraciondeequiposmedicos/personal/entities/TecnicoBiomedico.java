package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

import java.util.Objects;

public class TecnicoBiomedico extends Entity<TecnicoBiomedicoId> {
    private ResponsabilidadesTecnicas responsabilidadesTecnicas;

    public TecnicoBiomedico(TecnicoBiomedicoId entityId, ResponsabilidadesTecnicas responsabilidadesTecnicas) {
        super(entityId);
        this.responsabilidadesTecnicas = responsabilidadesTecnicas;
    }
    public void actulizarResponsabilidades(ResponsabilidadesTecnicas responsabilidadesTecnicas){
        this.responsabilidadesTecnicas = Objects.requireNonNull(responsabilidadesTecnicas);
    }

}
