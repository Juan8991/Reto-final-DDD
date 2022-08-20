package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.ActualizarFechaDelProximoMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.FechaDelProximoMantenimientoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCorrectivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoPreventivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDelMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoPreventivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelProximoMantenimiento;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoPreventivoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarFechaDelProximoMantenimientoPreventivoUseCaseTest {
    @InjectMocks
    private ActualizarFechaDelProximoMantenimientoPreventivoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarFechaHappyPass(){
        //arrange
        var command = new ActualizarFechaDelProximoMantenimientoPreventivo(
                MantenimientoId.of("Ma001"),
                MantenimientoPreventivoId.of("MP01"),
                new FechaDelProximoMantenimiento(LocalDate.of(2022,9,19))
        );
        when(repository.getEventsBy("Ma001")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMantenimientoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (FechaDelProximoMantenimientoActualizada)events.get(0);
        Assertions.assertEquals("MP01",event.getMantenimientoPreventivoId().value());
    }
    private List<DomainEvent> history() {
        var event = new MantenimientoCreado(new Herramientas("Destornillador"));
        event.setAggregateRootId("xxxx");
        var event2 = new MantenimientoPreventivoAgregado(
                MantenimientoPreventivoId.of("MP01"),
                new DescripcionDelMantenimiento("Limpieza general"),
                new FechaDelProximoMantenimiento(LocalDate.of(2022,10,19)),
                new FechaDelMantenimientoPreventivo(LocalDate.of(2022,8,19)));
        return List.of(event,event2);
    }

}