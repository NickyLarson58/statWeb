package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stat_intervention")
public class StatIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stat_intervention", nullable = false)
    private Long idStatIntervention;

    @Column(name = "date_interventions")
    private LocalDateTime dateInterventions;

    @Column(name = "nombre_intervention")
    private int nombreIntervention;

    @ManyToOne
    @JoinColumn(name = "id_interventions", referencedColumnName = "id_interventions", nullable = false)
    private Interventions intervention;

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "idadresse", nullable = false)
    private Adresses adresse;

    @ManyToOne
    @JoinColumn(name = "id_mad", referencedColumnName = "id_mad", nullable = true)
    private Mad mad;

    @ManyToOne
    @JoinColumn(name = "id_infraction", referencedColumnName = "id_infraction", nullable = true)
    private Infraction infraction;

    @ManyToMany
    @JoinColumn(name = "matricule_agent_intervention", referencedColumnName = "matricule", nullable = false)
    private List<Agents> agents;

    public Long getIdStatIntervention() {
        return idStatIntervention;
    }

    public void setIdStatIntervention(Long idStatIntervention) {
        this.idStatIntervention = idStatIntervention;
    }

    public LocalDateTime getDateInterventions() {
        return dateInterventions;
    }

    public void setDateInterventions(LocalDateTime dateInterventions) {
        this.dateInterventions = dateInterventions;
    }

    public int getNombreIntervention() {
        return nombreIntervention;
    }

    public void setNombreIntervention(int nombreIntervention) {
        this.nombreIntervention = nombreIntervention;
    }

    public Interventions getIntervention() {
        return intervention;
    }

    public void setIntervention(Interventions intervention) {
        this.intervention = intervention;
    }

    public Adresses getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresses adresse) {
        this.adresse = adresse;
    }

    public Mad getMad() {
        return mad;
    }

    public void setMad(Mad mad) {
        this.mad = mad;
    }

    public Infraction getInfraction() {
        return infraction;
    }

    public void setInfraction(Infraction infraction) {
        this.infraction = infraction;
    }

    public List<Agents> getAgents() {
        return agents;
    }

    public void setAgents(List<Agents> agents) {
        this.agents = agents;
    }
}