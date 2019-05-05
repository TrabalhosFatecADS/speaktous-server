package com.speakToUs.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario extends Pessoa implements Serializable {

    private int pontuacao;

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
