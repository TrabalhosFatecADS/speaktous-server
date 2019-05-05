package com.speakToUs.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Moderador extends Pessoa implements Serializable {

    private Boolean moderador;

    public Boolean getModerador() {
        return moderador;
    }

    public void setModerador(Boolean moderador) {
        this.moderador = moderador;
    }
}
