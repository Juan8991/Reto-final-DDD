package com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.personal.values;

import co.com.sofka.domain.generic.Identity;
import com.hospital.departamentodeingenieriabiomedica.administraciondeequiposmedicos.hojadevida.values.HojaDeVidaId;

public class PersonalId extends Identity {
    public PersonalId(String uuid) {
        super(uuid);
    }

    public PersonalId() {
    }
    public static PersonalId of(String uuid){
        return new PersonalId(uuid);
    }
}
