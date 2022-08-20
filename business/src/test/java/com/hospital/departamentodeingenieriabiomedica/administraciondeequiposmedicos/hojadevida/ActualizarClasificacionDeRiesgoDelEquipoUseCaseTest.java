package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarClasificacionDeRiesgoDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.ActualizarUbicacionDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.ClasificacionDeRiesgoActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.EquipoAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.UbiacionActualizada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.RegistroInvima;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;
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
class ActualizarClasificacionDeRiesgoDelEquipoUseCaseTest {
    @InjectMocks
    private ActualizarClasificacionDeRiesgoDelEquipoUseCase useCase;

    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarClasificacionDelRiesgoHappyPass() {
        //arrange
        HojaDeVidaId hojaDeVidaId = HojaDeVidaId.of("h01");
        EquipoId equipoId = EquipoId.of("E01");
        ClasificacionDelRiesgo clasificacionDelRiesgo = new ClasificacionDelRiesgo("III");
        var command = new ActualizarClasificacionDeRiesgoDelEquipo(hojaDeVidaId,equipoId,clasificacionDelRiesgo);

        when(repository.getEventsBy("h01")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHojaDeVidaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (ClasificacionDeRiesgoActualizada)events.get(0);
        Assertions.assertEquals("III",event.getClasificacionDelRiesgo().value());
    }
    private List<DomainEvent> history(){
        Serial serial = new Serial("dsd");
        var event= new HojaDeVidaCreada(serial);
        event.setAggregateRootId("h01");

        EquipoId equipoId = EquipoId.of("E01");
        DatosDelEquipo datosDelEquipo= new DatosDelEquipo("Monitor de signos","Mindray","Mec1200", "CC-3B127686");
        RegistroInvima registroInvima = new RegistroInvima("2009EBC-0003486");
        ClasificacionDelRiesgo clasificacionDelRiesgo= new ClasificacionDelRiesgo("IIB");
        Ubicacion ubicacion= new Ubicacion("Consulta Externa");
        var event2= new EquipoAsignado(equipoId,datosDelEquipo,registroInvima,clasificacionDelRiesgo,ubicacion);

        return List.of(event,event2);
    }

}