package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stat_intervention")
public class StatIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_stat_intervention;

    @Column(name = "date_interventions")
    private LocalDateTime date_interventions;

    @Column(name = "lieu_interventions", length = 45)
    private String lieu_interventions;

    @Column(name = "nombre_intervention")
    private int nombre_intervention;

    @ManyToOne
    @JoinColumn(name = "id_interventions", referencedColumnName = "idInterventions", nullable = false)
    private Interventions intervention;

    public StatIntervention() {
    }

    public int getId_stat_intervention() {
        return id_stat_intervention;
    }

    public void setId_stat_intervention(int id_stat_intervention) {
        this.id_stat_intervention = id_stat_intervention;
    }

    public LocalDateTime getDate_interventions() {
        return date_interventions;
    }

    public void setDate_interventions(LocalDateTime date_interventions) {
        this.date_interventions = date_interventions;
    }

    public String getLieu_interventions() {
        return lieu_interventions;
    }

    public void setLieu_interventions(String lieu_interventions) {
        this.lieu_interventions = lieu_interventions;
    }

    public Interventions getIntervention() {
        return intervention;
    }

    public void setIntervention(Interventions intervention) {
        this.intervention = intervention;
    }

    public int getNombre_intervention() {
        return nombre_intervention;
    }

    public void setNombre_intervention(int nombre_intervention) {
        this.nombre_intervention = nombre_intervention;
    }
}