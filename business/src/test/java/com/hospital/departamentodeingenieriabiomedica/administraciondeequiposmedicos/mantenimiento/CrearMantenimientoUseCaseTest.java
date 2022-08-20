package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.CrearHojaDeVidaUseCase;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.CrearMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearMantenimientoUseCaseTest {
    private CrearMantenimientoUseCase useCase;
    @BeforeEach
    public void setup() {
        useCase = new CrearMantenimientoUseCase();
    }
    @Test
    public void crearMantenimientoHappyPass(){
        //arrange
        var command= new CrearMantenimiento(MantenimientoId.of("M001"),new Herramientas("Multimetro"));
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var event= (MantenimientoCreado)events.get(0);
        Assertions.assertEquals("Multimetro",event.getHerramientas().value());
    }

}