package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.AsignarAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.AccesorioAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarAccesorioUseCaseTest {
    @InjectMocks
    private AsignarAccesorioUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup() {
        useCase = new AsignarAccesorioUseCase();
    }
    @Test
    public void asignarUnAccesorioHappyPass(){
        //arrange
        HojaDeVidaId hojaDeVidaId= HojaDeVidaId.of("HV01");
        AccesorioId accesorioId = AccesorioId.of("A001");
        DatosDelAccesorio datosDelAccesorio= new DatosDelAccesorio("Cable de paciente","Mindray","Para infante");
        var command = new AsignarAccesorio(hojaDeVidaId,accesorioId,datosDelAccesorio);

        when(repository.getEventsBy("HV01")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHojaDeVidaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AccesorioAsignado)events.get(0);
        Assertions.assertEquals("Cable de paciente", event.getDatosDelAccesorio().value().obtenerNombre());
    }
    private List<DomainEvent> history() {
        Serial serial = new Serial("DDD");
        var event = new HojaDeVidaCreada(serial);
        event.setAggregateRootId("HV01");
        return List.of(event);
    }

}