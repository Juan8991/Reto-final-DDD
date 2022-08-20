package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.AgregarMantenimientoCorrectivo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.commands.AgregarMantenimientoPreventivo;
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
import org.junit.jupiter.api.BeforeEach;
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
class AgregarMantenimientoCorrectivoUseCaseTest {
    @InjectMocks
    private AgregarMantenimientoCorrectivoUseCase useCase;

    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup() {
        useCase = new AgregarMantenimientoCorrectivoUseCase();
    }

    @Test
    public void AgregarMantenimientoPreventivoHappyPass(){
        var descripcionDelMantenimiento = new DescripcionDeMantenimientoCorrectivo("se reparo el tubo de rayos X de la maquina de rayos x");
        var diagnostico = new Diagnostico("La maquina emitia altos niveles de radiación");
        var fechaDelMantenimientoCorrectivo = new FechaDelMantenimientoCorrectivo(LocalDate.of(2018,04,03));
        var command = new AgregarMantenimientoCorrectivo(MantenimientoId.of("xxx"),
                MantenimientoCorrectivoId.of("000"),
                diagnostico,
                descripcionDelMantenimiento,
                fechaDelMantenimientoCorrectivo);

        when(repository.getEventsBy("xxx")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMantenimientoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (MantenimientoCorrectivoAgregado)events.get(0);
        Assertions.assertEquals("La maquina emitia altos niveles de radiación",event.getDiagnostico().value());
    }
    private List<DomainEvent> history() {
        var event = new MantenimientoCreado(new Herramientas("Destornillador"));
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}