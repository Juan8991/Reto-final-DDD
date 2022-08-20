package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.CrearMantenimiento;

public class CrearMantenimientoUseCase extends UseCase<RequestCommand<CrearMantenimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMantenimiento> crearMantenimientoRequestCommand) {
        var command = crearMantenimientoRequestCommand.getCommand();
        var mantenimiento = new Mantenimiento(command.getMantenimientoId(),command.getHerramientas());
        emit().onResponse(new ResponseEvents(mantenimiento.getUncommittedChanges()));
    }
}
