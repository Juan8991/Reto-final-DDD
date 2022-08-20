package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarClasificacionDeRiesgoDelEquipo;

public class ActualizarClasificacionDeRiesgoDelEquipoUseCase extends UseCase<RequestCommand<ActualizarClasificacionDeRiesgoDelEquipo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarClasificacionDeRiesgoDelEquipo> actualizarClasificacionDeRiesgoDelEquipoRequestCommand) {
        var command = actualizarClasificacionDeRiesgoDelEquipoRequestCommand.getCommand();
        var hojaDeVida = HojaDeVida.from(command.getHojaDeVidaId(),repository().getEventsBy(command.getHojaDeVidaId().value()));
        hojaDeVida.actualizarClasificacionDeRiesgoDelEquipo(command.getEquipoId(),command.getClasificacionDelRiesgo());
        emit().onResponse(new ResponseEvents(hojaDeVida.getUncommittedChanges()));

    }
}
