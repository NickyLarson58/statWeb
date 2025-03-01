package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interventions")
public class Interventions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idInterventions;

    @Column(name = "nomInterventions")
    private String nomInterventions;

    public Interventions() {
    }

    public Interventions(String nomInterventions) {
        this.nomInterventions = nomInterventions;
    }

    public int getIdInterventions() {
        return idInterventions;
    }

    public String getNomInterventions() {
        return nomInterventions;
    }

    public void setNomInterventions(String nomInterventions) {
        this.nomInterventions = nomInterventions;
    }

    @Override
    public String toString() {
        return "Interventions [idInterventions=" + idInterventions + ", nomInterventions=" + nomInterventions + "]";
    }
}