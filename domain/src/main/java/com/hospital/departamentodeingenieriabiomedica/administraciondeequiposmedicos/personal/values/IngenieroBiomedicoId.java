package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.Identity;

public class IngenieroBiomedicoId extends Identity {
    public IngenieroBiomedicoId(String uuid) {
        super(uuid);
    }

    public IngenieroBiomedicoId() {
    }
    public static IngenieroBiomedicoId of(String uuid){
        return new IngenieroBiomedicoId(uuid);
    }
}
