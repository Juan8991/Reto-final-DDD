package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.ActualizarPersonalACargoDelIngenieroBiomedico;

public class ActualizarPersonalACargoDelIngenieroBiomedicoUseCase extends UseCase<RequestCommand<ActualizarPersonalACargoDelIngenieroBiomedico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarPersonalACargoDelIngenieroBiomedico> actualizarPersonalACargoDelIngenieroBiomedicoRequestCommand) {
        var command = actualizarPersonalACargoDelIngenieroBiomedicoRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.actualizarPersonalAcargoDelIngenieroBiomedico(command.getIngenieroBiomedicoId(),command.getPersonalACargo());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
