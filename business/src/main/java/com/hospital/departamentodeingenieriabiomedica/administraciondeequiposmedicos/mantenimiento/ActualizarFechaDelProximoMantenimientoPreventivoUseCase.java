package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.ActualizarFechaDelProximoMantenimientoPreventivo;

public class ActualizarFechaDelProximoMantenimientoPreventivoUseCase extends UseCase<RequestCommand<ActualizarFechaDelProximoMantenimientoPreventivo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarFechaDelProximoMantenimientoPreventivo> actualizarFechaDelProximoMantenimientoPreventivoRequestCommand) {
        var command = actualizarFechaDelProximoMantenimientoPreventivoRequestCommand.getCommand();
        var mantenimiento = Mantenimiento.from(command.getMantenimientoId(),repository().getEventsBy(command.getMantenimientoId().value()));
        mantenimiento.actualizarFechaDelProximoMantenimientoPreventivo(command.getMantenimientoPreventivoId(),command.getFechaDelProximoMantenimiento());
        emit().onResponse(new ResponseEvents(mantenimiento.getUncommittedChanges()));
    }
}
