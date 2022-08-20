package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.ActualizarDescripcionDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.DescripcionDelMantenimientoCorrectivoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCorrectivoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.events.MantenimientoCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.DescripcionDeMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Diagnostico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.FechaDelMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.Herramientas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoCorrectivoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
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
class ActualizarDescripcionDelMantenimientoCorrectivoUseCaseTest {
    @InjectMocks
    private ActualizarDescripcionDelMantenimientoCorrectivoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarDescripcionHappyPass(){
        //arrange
        var command = new ActualizarDescripcionDelMantenimientoCorrectivo(
                MantenimientoId.of("Ma001"),
                MantenimientoCorrectivoId.of("Co001"),
                new DescripcionDeMantenimientoCorrectivo("Descripcion actualizada"));
        when(repository.getEventsBy("Ma001")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMantenimientoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event =(DescripcionDelMantenimientoCorrectivoActualizada)events.get(0);
        Assertions.assertEquals("Descripcion actualizada",event.getDescripcionDeMantenimientoCorrectivo().value());

    }
    private List<DomainEvent> history() {
        var event = new MantenimientoCreado(new Herramientas("Destornillador"));
        event.setAggregateRootId("xxxx");

        var descripcionDelMantenimiento = new DescripcionDeMantenimientoCorrectivo("se reparo el tubo de rayos X de la maquina de rayos x");
        var diagnostico = new Diagnostico("La maquina emitia altos niveles de radiación");
        var fechaDelMantenimientoCorrectivo = new FechaDelMantenimientoCorrectivo(LocalDate.of(2018,04,03));
        var event2 = new MantenimientoCorrectivoAgregado(
                MantenimientoCorrectivoId.of("000"),
                diagnostico,
                descripcionDelMantenimiento,
                fechaDelMantenimientoCorrectivo);
        return List.of(event,event2);
    }
}