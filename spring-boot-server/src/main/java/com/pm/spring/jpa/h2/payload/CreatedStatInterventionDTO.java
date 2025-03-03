package com.pm.spring.jpa.h2.payload;

import com.pm.spring.jpa.h2.model.Agents;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CreatedStatInterventionDTO {
    private int idIntervention;
    private LocalDateTime dateIntervention;
    private String nomInterventions;
    private Integer nombreIntervention;
    private Long idAdresse;
    private Long idInfraction;
    private Long idMad;
    private List<Agents> agents;

    public Long getIdMad() {
        return idMad;
    }

    public void setIdMad(Long idMad) {
        this.idMad = idMad;
    }

    public Long getIdInfraction() {
        return idInfraction;
    }

    public void setIdInfraction(Long idInfraction) {
        this.idInfraction = idInfraction;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getNombreIntervention() {
        return nombreIntervention;
    }

    public void setNombreIntervention(Integer nombreIntervention) {
        this.nombreIntervention = nombreIntervention;
    }

    public String getNomInterventions() {
        return nomInterventions;
    }

    public void setNomInterventions(String nomInterventions) {
        this.nomInterventions = nomInterventions;
    }

    public LocalDateTime getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(LocalDateTime dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public int getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(int idIntervention) {
        this.idIntervention = idIntervention;
    }

    public List<Agents> getAgents() {
        return agents;
    }

    public void setAgents(List<Agents> agents) {
        this.agents = agents;
    }
}