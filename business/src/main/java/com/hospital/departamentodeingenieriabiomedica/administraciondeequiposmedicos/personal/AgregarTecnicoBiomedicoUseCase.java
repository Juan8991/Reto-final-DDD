package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.AgregarTecnicoBiomedico;

public class AgregarTecnicoBiomedicoUseCase extends UseCase<RequestCommand<AgregarTecnicoBiomedico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTecnicoBiomedico> agregarTecnicoBiomedicoRequestCommand) {
        var command = agregarTecnicoBiomedicoRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.agregarTecnicoBiomedico(command.getTecnicoBiomedicoId(),command.getResponsabilidadesTecnicas());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
