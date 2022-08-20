package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.AgregarIngenieroBiomedico;

public class AgregarIngenieroBiomedicoUseCase extends UseCase<RequestCommand<AgregarIngenieroBiomedico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarIngenieroBiomedico> agregarIngenieroBiomedicoRequestCommand) {
        var command = agregarIngenieroBiomedicoRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.agregarIngenieroBiomedico(command.getIngenieroBiomedicoId(),command.getPersonalACargo(),command.getResponsabilidades());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
