package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.AsignarEquipo;

public class AsignarEquipoUseCase extends UseCase<RequestCommand<AsignarEquipo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarEquipo> asignarEquipoRequestCommand) {
        var command= asignarEquipoRequestCommand.getCommand();
        var hojaDeVida = HojaDeVida.from(
                command.getHojaDeVidaId(),repository().getEventsBy(command.getHojaDeVidaId().value())
        );
        hojaDeVida.asignarEquipo(
                command.getEquipoId(),
                command.getDatosDelEquipo(),
                command.getRegistroInvima(),
                command.getClasificacionDelRiesgo(),
                command.getUbicacion()
        );

        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));
    }
}
