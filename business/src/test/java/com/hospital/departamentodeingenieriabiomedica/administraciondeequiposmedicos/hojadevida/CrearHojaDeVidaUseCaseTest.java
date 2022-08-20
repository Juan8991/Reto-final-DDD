package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.CrearHojaDeVida;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearHojaDeVidaUseCaseTest {
    private CrearHojaDeVidaUseCase useCase;
    @BeforeEach
    public void setup() {
        useCase = new CrearHojaDeVidaUseCase();
    }
    @Test
    public void crearHojaDeVidaHappyPass() {
        //arrange
        var hojaVidaId= HojaDeVidaId.of("h01");
        var serial= new Serial("ahb01");
        var command = new CrearHojaDeVida(hojaVidaId,serial);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var event=(HojaDeVidaCreada)events.get(0);
        Assertions.assertEquals("ahb01",event.getSerial().value());
    }
}