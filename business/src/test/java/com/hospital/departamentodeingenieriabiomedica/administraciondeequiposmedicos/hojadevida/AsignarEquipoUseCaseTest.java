package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands.AsignarEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.EquipoAsignado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events.HojaDeVidaCreada;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.RegistroInvima;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Serial;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;
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
class AsignarEquipoUseCaseTest {
    @InjectMocks
    private AsignarEquipoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup() {
        useCase = new AsignarEquipoUseCase();
    }
    @Test
    public void asignarUnEquipoHappyPass(){
        //arrange
        HojaDeVidaId hojaDeVidaId= HojaDeVidaId.of("HV01");
        EquipoId equipoId = EquipoId.of("E001");
        DatosDelEquipo datosDelEquipo= new DatosDelEquipo("Monitor de signos","Mindray","Mec1200", "CC-3B127686");
        RegistroInvima registroInvima = new RegistroInvima("2009EBC-0003486");
        ClasificacionDelRiesgo clasificacionDelRiesgo= new ClasificacionDelRiesgo("IIB");
        Ubicacion ubicacion= new Ubicacion("Consulta Externa");
        var command = new AsignarEquipo(hojaDeVidaId,equipoId,datosDelEquipo,registroInvima,clasificacionDelRiesgo,ubicacion);

        when(repository.getEventsBy("HV01")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHojaDeVidaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EquipoAsignado)events.get(0);
        Assertions.assertEquals("2009EBC-0003486", event.getRegistroInvima().value());

    }
    private List<DomainEvent> history() {
        Serial serial = new Serial("DDD");
        var event = new HojaDeVidaCreada(serial);
        event.setAggregateRootId("HV01");
        return List.of(event);
    }
}