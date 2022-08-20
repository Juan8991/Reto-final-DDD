package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.AgregarMantenimientoPreventivo;

public class AgregarMantenimientoPreventivoUseCase extends UseCase<RequestCommand<AgregarMantenimientoPreventivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMantenimientoPreventivo> agregarMantenimientoPreventivoRequestCommand) {
        var command = agregarMantenimientoPreventivoRequestCommand.getCommand();

        Mantenimiento mantenimiento = Mantenimiento.from(
                command.getMantenimientoId(),
                repository().getEventsBy(command.getMantenimientoId().value()));
        mantenimiento.agregarMantenimientoPreventivo(command.getMantenimientoPreventivoId(),command.getDescripcionDelMantenimiento(),command.getFechaDelProximoMantenimiento(),command.getFechaDelMantenimientoPreventivo());
        emit().onResponse(new ResponseEvents(mantenimiento.getUncommittedChanges()));
    }
}
