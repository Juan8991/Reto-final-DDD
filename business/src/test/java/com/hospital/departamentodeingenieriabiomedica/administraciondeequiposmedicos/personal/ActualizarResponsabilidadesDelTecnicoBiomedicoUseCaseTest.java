package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.ActualizarResponsabilidadesDelTecnicoBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.ResponsabilidadesDelTecnicoActualizadas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.TecnicoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
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
class ActualizarResponsabilidadesDelTecnicoBiomedicoUseCaseTest {
    @InjectMocks
    private ActualizarResponsabilidadesDelTecnicoBiomedicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarResponsabilidadesHappyPass(){
        var command = new ActualizarResponsabilidadesDelTecnicoBiomedico(
                PersonalId.of("P01"),
                TecnicoBiomedicoId.of("T01"),
                new ResponsabilidadesTecnicas("Realizar mantenimiento Preventivo"));
        when(repository.getEventsBy("P01")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ResponsabilidadesDelTecnicoActualizadas)events.get(0);
        Assertions.assertEquals("Realizar mantenimiento Preventivo",event.getResponsabilidades().value());
    }
    private List<DomainEvent> history() {
        var event = new PersonalCreado(new DatosPersonales("Paco","3204157892","paco@gmail.com"));
        event.setAggregateRootId("xxxx");
        var event2= new TecnicoAgregado(TecnicoBiomedicoId.of("Tec01"),
                new ResponsabilidadesTecnicas("Actualizar hojas de vida"));
        return List.of(event,event2);
    }

}