package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.mantenimiento.values.MantenimientoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities.IngenieroBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.entities.TecnicoBiomedico;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.IngenieroAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalACargoActualizado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.PersonalCreado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.ResponsabilidadesDelTecnicoActualizadas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.events.TecnicoAgregado;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.DatosPersonales;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.IngenieroBiomedicoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalACargo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.PersonalId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.Responsabilidades;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.ResponsabilidadesTecnicas;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values.TecnicoBiomedicoId;

import java.util.List;
import java.util.Objects;

public class Personal extends AggregateEvent<PersonalId> {
    protected HojaDeVidaId hojaDeVidaId;
    protected MantenimientoId mantenimientoId;
    protected IngenieroBiomedico ingenieroBiomedico;
    protected TecnicoBiomedico tecnicoBiomedico;
    protected DatosPersonales datosPersonales;

    public Personal(PersonalId entityId, DatosPersonales datosPersonales) {
        super(entityId);
        appendChange(new PersonalCreado(datosPersonales)).apply();
        subscribe(new PersonalEventChange(this));
    }
    public Personal(PersonalId entityId){
        super(entityId);
    }
    public static Personal from(PersonalId personalId, List<DomainEvent> events){
        var personal = new Personal(personalId);
        events.forEach(personal::applyEvent);
        return personal;
    }
    public void actualizarPersonalAcargoDelIngenieroBiomedico(IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo){
        Objects.requireNonNull(ingenieroBiomedicoId);
        Objects.requireNonNull(personalACargo);
        appendChange(new PersonalACargoActualizado(ingenieroBiomedicoId,personalACargo)).apply();
    }
    public void actualizarResponsabilidadesDelTecnicoBiomedico(TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidades){
        Objects.requireNonNull(tecnicoBiomedicoId);
        Objects.requireNonNull(responsabilidades);
        appendChange(new ResponsabilidadesDelTecnicoActualizadas(tecnicoBiomedicoId,responsabilidades)).apply();
    }
    public void agregarTecnicoBiomedico(TecnicoBiomedicoId tecnicoBiomedicoId, ResponsabilidadesTecnicas responsabilidadesTecnicas){
        Objects.requireNonNull(tecnicoBiomedicoId);
        Objects.requireNonNull(responsabilidadesTecnicas);
        appendChange(new TecnicoAgregado(tecnicoBiomedicoId,responsabilidadesTecnicas)).apply();
    }
    public void agregarIngenieroBiomedico(IngenieroBiomedicoId ingenieroBiomedicoId, PersonalACargo personalACargo, Responsabilidades responsabilidades){
        Objects.requireNonNull(ingenieroBiomedicoId);
        Objects.requireNonNull(personalACargo);
        Objects.requireNonNull(responsabilidades);
        appendChange(new IngenieroAgregado(ingenieroBiomedicoId,personalACargo,responsabilidades)).apply();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public MantenimientoId mantenimientoId() {
        return mantenimientoId;
    }

    public IngenieroBiomedico ingenieroBiomedico() {
        return ingenieroBiomedico;
    }

    public TecnicoBiomedico tecnicoBiomedico() {
        return tecnicoBiomedico;
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
