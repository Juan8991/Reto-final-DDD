package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarDatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.AccesorioAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.DatosDelAccesorioActualizados;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosDelAccesorioUseCaseTest {
    @InjectMocks
    private ActualizarDatosDelAccesorioUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarDatosAccesorioHappyPass(){
        //arrange
        var command = new ActualizarDatosDelAccesorio(
                HojaDeVidaId.of("H01"),
                AccesorioId.of("A01"),
                new DatosDelAccesorio("Brazalete","Mindray","Pediatrico"));
        when(repository.getEventsBy("H01")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHojaDeVidaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DatosDelAccesorioActualizados)events.get(0);
        Assertions.assertEquals("Brazalete", event.getDatosDelAccesorio().value().obtenerNombre());
        Assertions.assertEquals("Mindray", event.getDatosDelAccesorio().value().obtenerMarca());
        Assertions.assertEquals("Pediatrico", event.getDatosDelAccesorio().value().obtenerModelo());
    }
    private List<DomainEvent> history() {
        Serial serial = new Serial("DDD");
        var event = new HojaDeVidaCreada(serial);
        event.setAggregateRootId("HV01");
        var event2 = new AccesorioAsignado(AccesorioId.of("A01"),
                new DatosDelAccesorio("Diafragma","Mindray","Adulto"));
        return List.of(event,event2);
    }

}