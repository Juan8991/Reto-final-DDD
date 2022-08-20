package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarUbicacionDelEquipo;

public class ActualizarUbicacionDelEquipoUseCase extends UseCase<RequestCommand<ActualizarUbicacionDelEquipo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarUbicacionDelEquipo> actualizarUbicacionDelEquipoRequestCommand) {
        var command = actualizarUbicacionDelEquipoRequestCommand.getCommand();
        var hojaDeVida = HojaDeVida.from(command.getHojaDeVidaId(),repository().getEventsBy(command.getHojaDeVidaId().value()));
        hojaDeVida.actualizarUbicacionDelEquipo(command.getEquipoId(),command.getUbicacion());
        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));
    }
}
