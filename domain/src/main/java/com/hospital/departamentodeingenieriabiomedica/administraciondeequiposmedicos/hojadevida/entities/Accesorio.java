package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.entities;

import co.com.sofka.domain.generic.Entity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;

import java.util.Objects;

public class Accesorio extends Entity<AccesorioId> {
    private DatosDelAccesorio datosDelAccesorio;

    public Accesorio(AccesorioId entityId, DatosDelAccesorio datosDelAccesorio) {
        super(entityId);
        this.datosDelAccesorio = datosDelAccesorio;
    }
    public void actualizarDatosDelAccesorio(DatosDelAccesorio datosDelAccesorio){
        this.datosDelAccesorio= Objects.requireNonNull(datosDelAccesorio);
    }

}
