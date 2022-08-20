package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.AsignarAccesorio;

public class AsignarAccesorioUseCase extends UseCase<RequestCommand<AsignarAccesorio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarAccesorio> asignarAccesorioRequestCommand) {
        var command = asignarAccesorioRequestCommand.getCommand();
        var hojaDeVida= HojaDeVida.from(command.getHojaDeVidaId(),repository().getEventsBy(command.getHojaDeVidaId().value()));
        hojaDeVida.asignarAccesorio(command.getAccesorioId(),command.getDatosDelAccesorio());
        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));
    }
}
