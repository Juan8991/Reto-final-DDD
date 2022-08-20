package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.AgregarMantenimientoCorrectivo;

public class AgregarMantenimientoCorrectivoUseCase extends UseCase<RequestCommand<AgregarMantenimientoCorrectivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMantenimientoCorrectivo> agregarMantenimientoCorrectivoRequestCommand) {
        var command = agregarMantenimientoCorrectivoRequestCommand.getCommand();
        Mantenimiento mantenimiento = Mantenimiento.from(
                command.getMantenimientoId(),
                repository().getEventsBy(command.getMantenimientoId().value()));
        mantenimiento.agregarMantenimientoCorrectivo(command.getMantenimientoCorrectivoId(),command.getDescripcionDeMantenimientoCorrectivo(),command.getFechaDelMantenimientoCorrectivo(),command.getDiagnostico());
        emit().onResponse(new ResponseEvents(mantenimiento.getUncommittedChanges()));
    }
}
