package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.AgregarMantenimientoPreventivoUseCase;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.commands.AgregarTecnicoBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.TecnicoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;
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
class AgregarTecnicoBiomedicoUseCaseTest {
    @InjectMocks
    private AgregarTecnicoBiomedicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup() {
        useCase = new AgregarTecnicoBiomedicoUseCase();
    }
    @Test
    public void AgregarTecnicoHappyPass(){
        //arrange
        var command = new AgregarTecnicoBiomedico(
                PersonalId.of("Per01"),
                TecnicoBiomedicoId.of("Tec01"),
                new ResponsabilidadesTecnicas("Actualizar hojas de vida")
        );
        when(repository.getEventsBy("Per01")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (TecnicoAgregado)events.get(0);
        Assertions.assertEquals("Actualizar hojas de vida",event.getResponsabilidadesTecnicas().value());
    }
    private List<DomainEvent> history() {
        var event = new PersonalCreado(new DatosPersonales("Paco","3204157892","paco@gmail.com"));
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }


}