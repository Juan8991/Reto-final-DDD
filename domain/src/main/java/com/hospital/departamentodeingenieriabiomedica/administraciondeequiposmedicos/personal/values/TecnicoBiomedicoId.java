package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.Identity;

public class TecnicoBiomedicoId extends Identity {
    public TecnicoBiomedicoId(String uuid) {
        super(uuid);
    }

    public TecnicoBiomedicoId() {
    }
    public static TecnicoBiomedicoId of(String uuid){
        return new TecnicoBiomedicoId(uuid);
    }
}
