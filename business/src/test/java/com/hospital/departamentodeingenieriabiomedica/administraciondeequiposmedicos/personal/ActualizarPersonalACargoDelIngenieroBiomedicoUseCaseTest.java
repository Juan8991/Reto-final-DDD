package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;



import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.ActualizarPersonalACargoDelIngenieroBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.IngenieroAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalACargoActualizado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.TecnicoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;
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
class ActualizarPersonalACargoDelIngenieroBiomedicoUseCaseTest {
    @InjectMocks
    private ActualizarPersonalACargoDelIngenieroBiomedicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarPersonalACargoHappyPass(){
        var command = new ActualizarPersonalACargoDelIngenieroBiomedico(
                PersonalId.of("P01"),
                IngenieroBiomedicoId.of("I01"),
                new PersonalACargo("Sofia","781115645","sofia@gmail.com"));
        when(repository.getEventsBy("P01")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (PersonalACargoActualizado)events.get(0);
        Assertions.assertEquals("Sofia",event.getPersonalACargo().value().obtenerNombre());
        Assertions.assertEquals("781115645",event.getPersonalACargo().value().obtenerTelefono());
        Assertions.assertEquals("sofia@gmail.com",event.getPersonalACargo().value().obtenerCorreo());


    }
    private List<DomainEvent> history() {
        var event = new PersonalCreado(new DatosPersonales("Paco","3204157892","paco@gmail.com"));
        event.setAggregateRootId("xxxx");
        var event2= new IngenieroAgregado(IngenieroBiomedicoId.of("I01"),
                new PersonalACargo("marcos","3201115645","marcos@gmail.com"),
                new Responsabilidades("Liderar"));
        return List.of(event,event2);
    }

}