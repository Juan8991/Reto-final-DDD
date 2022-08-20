package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.CrearHojaDeVida;
public class CrearHojaDeVidaUseCase extends UseCase<RequestCommand<CrearHojaDeVida>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearHojaDeVida> crearHojaDeVidaRequestCommand) {
        var command = crearHojaDeVidaRequestCommand.getCommand();
        var hojaDeVida= new HojaDeVida(command.getHojaDeVidaId(),command.getSerial());
        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));
    }
}
