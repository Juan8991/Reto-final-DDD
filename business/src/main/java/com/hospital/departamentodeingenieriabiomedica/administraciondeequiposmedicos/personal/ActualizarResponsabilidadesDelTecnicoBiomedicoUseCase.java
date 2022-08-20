package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.ActualizarResponsabilidadesDelTecnicoBiomedico;

public class ActualizarResponsabilidadesDelTecnicoBiomedicoUseCase extends UseCase<RequestCommand<ActualizarResponsabilidadesDelTecnicoBiomedico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarResponsabilidadesDelTecnicoBiomedico> actualizarResponsabilidadesDelTecnicoBiomedicoRequestCommand) {
        var command = actualizarResponsabilidadesDelTecnicoBiomedicoRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.actualizarResponsabilidadesDelTecnicoBiomedico(command.getTecnicoBiomedicoId(),command.getResponsabilidades());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
