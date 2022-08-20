package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities.IngenieroBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities.TecnicoBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.IngenieroAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalACargoActualizado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.ResponsabilidadesDelTecnicoActualizadas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.TecnicoAgregado;

public class PersonalEventChange extends EventChange {
    public PersonalEventChange(Personal personal) {
        apply((PersonalCreado event) -> {
            personal.datosPersonales=event.getDatosPersonales();
        });
        apply((IngenieroAgregado event) -> {
            personal.ingenieroBiomedico = new IngenieroBiomedico(event.getIngenieroBiomedicoId(),event.getPersonalACargo(),event.getResponsabilidades());
        });
        apply((TecnicoAgregado event) -> {
            personal.tecnicoBiomedico = new TecnicoBiomedico(event.getTecnicoBiomedicoId(),event.getResponsabilidadesTecnicas());
        });
        apply((PersonalACargoActualizado event) -> {
            personal.ingenieroBiomedico.actualizarPersonalAcargo(event.getPersonalACargo());
        });
        apply((ResponsabilidadesDelTecnicoActualizadas event) -> {
            personal.tecnicoBiomedico.actulizarResponsabilidades(event.getResponsabilidades());
        });

    }
}
