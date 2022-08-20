package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.ActualizarDescripcionDelMantenimientoCorrectivo;

public class ActualizarDescripcionDelMantenimientoCorrectivoUseCase extends UseCase<RequestCommand<ActualizarDescripcionDelMantenimientoCorrectivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionDelMantenimientoCorrectivo> actualizarDescripcionDelMantenimientoCorrectivoRequestCommand) {
        var command = actualizarDescripcionDelMantenimientoCorrectivoRequestCommand.getCommand();
        var mantenimiento = Mantenimiento.from(command.getMantenimientoId(),repository().getEventsBy(command.getMantenimientoId().value()));
        mantenimiento.actualizarDescripcionDelMantenimientoCorrectivo(command.getMantenimientoCorrectivoId(),command.getDescripcionDeMantenimientoCorrectivo());
        emit().onResponse(new ResponseEvents(mantenimiento.getUncommittedChanges()));
    }
}
