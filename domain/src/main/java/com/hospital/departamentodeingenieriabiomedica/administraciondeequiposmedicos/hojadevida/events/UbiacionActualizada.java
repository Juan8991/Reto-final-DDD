package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.EquipoId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.Ubicacion;

public class UbiacionActualizada extends DomainEvent {
    private final EquipoId equipoId;
    private final Ubicacion ubicacion;

    public UbiacionActualizada(EquipoId equipoId, Ubicacion ubicacion) {
        super("com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.UbiacionActualizada");
        this.equipoId = equipoId;
        this.ubicacion = ubicacion;
    }
    public EquipoId getEquipoId() {
        return equipoId;
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
