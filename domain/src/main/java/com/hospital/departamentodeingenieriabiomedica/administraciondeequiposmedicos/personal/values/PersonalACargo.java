package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.ValueObject;

public class PersonalACargo implements ValueObject<PersonalACargo.Props> {
    private final String nombre;
    private final String telefono;
    private final String correo;

    public PersonalACargo(String nombre, String telefono, String correo) {
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
