package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarDatosDelAccesorio;

public class ActualizarDatosDelAccesorioUseCase extends UseCase<RequestCommand<ActualizarDatosDelAccesorio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosDelAccesorio> actualizarDatosDelAccesorioRequestCommand) {
        var command = actualizarDatosDelAccesorioRequestCommand.getCommand();
        var hojaDeVida = HojaDeVida.from(command.getHojaDeVidaId(),repository().getEventsBy(command.getHojaDeVidaId().value()));
        hojaDeVida.actualizarDatosDelAccesorio(command.getDatosDelAccesorio());
        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));


    }
}
