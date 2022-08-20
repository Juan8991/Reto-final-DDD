package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.AgregarIngenieroBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.IngenieroAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;
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
class AgregarIngenieroBiomedicoUseCaseTest {
    @InjectMocks
    private AgregarIngenieroBiomedicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup() {
        useCase = new AgregarIngenieroBiomedicoUseCase();
    }
    @Test
    public void agregarIngenieroHappyPass(){
        //arrange
        var command = new AgregarIngenieroBiomedico(
                PersonalId.of("Per01"),
                IngenieroBiomedicoId.of("Bio01"),
                new PersonalACargo("Carlos","3203242345","carlos@gmail.com"),
                new Responsabilidades("Realizar manteniemientos correctivos"));
        when(repository.getEventsBy("Per01")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event =(IngenieroAgregado)events.get(0);
        Assertions.assertEquals("Realizar manteniemientos correctivos",event.getResponsabilidades().value());

    }
    private List<DomainEvent> history() {
        var event = new PersonalCreado(new DatosPersonales("Paco","3204157892","paco@gmail.com"));
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}