package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.AccesorioId;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelAccesorio;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class ActualizarDatosDelAccesorio extends Command {
    private final HojaDeVidaId hojaDeVidaId;
    private final AccesorioId accesorioId;
    private final DatosDelAccesorio datosDelAccesorio;

    public ActualizarDatosDelAccesorio(HojaDeVidaId hojaDeVidaId, AccesorioId accesorioId, DatosDelAccesorio datosDelAccesorio) {
        this.hojaDeVidaId = hojaDeVidaId;
        this.accesorioId = accesorioId;
        this.datosDelAccesorio = datosDelAccesorio;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public AccesorioId getAccesorioId() {
        return accesorioId;
    }

    public DatosDelAccesorio getDatosDelAccesorio() {
        return datosDelAccesorio;
    }

}

