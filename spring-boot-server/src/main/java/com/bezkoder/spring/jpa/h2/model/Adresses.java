package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adresses")
public class Adresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idadresse;
  
    @Column(name = "nomadresse")
    private String nomadresse;

    public Adresses() {
    }

    public Adresses(String nomadresse) {
        this.nomadresse = nomadresse;
    }

    public long getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(long idadresse) {
        this.idadresse = idadresse;
    }

    public String getNomadresse() {
        return nomadresse;
    }

    public void setNomadresse(String nomadresse) {
        this.nomadresse = nomadresse;
    }

    @Override
    public String toString() {
        return "Adresses [idadresse=" + idadresse + ", nomadresse=" + nomadresse + "]";
    }
}
