package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.CrearPersonal;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPersonalUseCaseTest {
    private CrearPersonalUseCase useCase;
    @BeforeEach
    public void setup() {
        useCase = new CrearPersonalUseCase();
    }
    @Test
    public void crearPersonalHappyPass(){
        //arrange
        var command = new CrearPersonal(
                PersonalId.of("P01"),
                new DatosPersonales("Paco","3204157892","paco@gmail.com"));
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event= (PersonalCreado)events.get(0);
        Assertions.assertEquals("Paco",event.getDatosPersonales().value().obtenerNombre());
        Assertions.assertEquals("3204157892",event.getDatosPersonales().value().obtenerTelefono());
        Assertions.assertEquals("paco@gmail.com",event.getDatosPersonales().value().obtenerCorreo());
    }

}