package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values;

import co.com.sofka.domain.generic.ValueObject;

public class DatosDelEquipo implements ValueObject<DatosDelEquipo.Props> {
    private final String nombre;
    private final String marca;
    private final String modelo;
    private final String numeroDeSerie;

    public DatosDelEquipo(String nombre, String marca, String modelo, String numeroDeSerie) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroDeSerie = numeroDeSerie;
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
            @Override
            public String obtenerNumeroDeSerie(){
                return numeroDeSerie;
            }
        };
    }
    public interface Props {
        String obtenerNombre();
        String obtenerMarca();
        String obtenerModelo();
        String obtenerNumeroDeSerie();

    }
}
