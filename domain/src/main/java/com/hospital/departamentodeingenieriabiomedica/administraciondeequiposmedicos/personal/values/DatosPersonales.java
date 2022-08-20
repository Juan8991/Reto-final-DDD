package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.ValueObject;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.DatosDelEquipo;

public class DatosPersonales implements ValueObject<DatosPersonales.Props> {
    private final String nombre;
    private final String telefono;
    private final String correo;

    public DatosPersonales(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    @Override
    public Props value() {
        return new Props() {
            @Override
            public String obtenerNombre() {
                return nombre;
            }
            @Override
            public String obtenerTelefono() {
                return telefono;
            }
            @Override
            public String obtenerCorreo() {
                return correo;
            }

        };
    }
    public interface Props {
        String obtenerNombre();
        String obtenerTelefono();
        String obtenerCorreo();
    }
}
