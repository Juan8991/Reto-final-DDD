package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class DatosDelAccesorio implements ValueObject<DatosDelAccesorio.Props> {
    private final String nombre;
    private final String marca;
    private final String modelo;

    public DatosDelAccesorio(String nombre, String marca, String modelo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }
    @Override
    public Props value() {
        return new Props() {
            @Override
            public String obtenerNombre() {
                return nombre;
            }
            @Override
            public String obtenerMarca() {
                return marca;
            }
            @Override
            public String obtenerModelo() {
                return modelo;
            }

        };
    }
    public interface Props {
        String obtenerNombre();
        String obtenerMarca();
        String obtenerModelo();


    }
}
