package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.ClasificacionDelRiesgo;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class ClasificacionDeRiesgoActualizada extends DomainEvent {
    private final EquipoId equipoId;
    private final ClasificacionDelRiesgo clasificacionDelRiesgo;

    public ClasificacionDeRiesgoActualizada( EquipoId equipoId, ClasificacionDelRiesgo clasificacionDelRiesgo) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.ClasificacionDeRiesgoActualizada");
        this.equipoId = equipoId;
        this.clasificacionDelRiesgo = clasificacionDelRiesgo;
    }

    public EquipoId getEquipoId() {
        return equipoId;
    }

    public ClasificacionDelRiesgo getClasificacionDelRiesgo() {
        return clasificacionDelRiesgo;
    }
}
