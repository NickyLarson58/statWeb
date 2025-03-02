package com.pm.spring.jpa.h2.payload;

import java.time.LocalDate;

public class CreatedStatInterventionDTO {
    private Long idIntervention;
    private LocalDate dateIntervention;
    private String nomInterventions;
    private Integer nombreIntervention;
    private Long idAdresse;
    private Long idInfraction;
    private Long idMad;

    // Getters and Setters
    public Long getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(Long idIntervention) {
        this.idIntervention = idIntervention;
    }

    public LocalDate getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(LocalDate dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public String getNomInterventions() {
        return nomInterventions;
    }

    public void setNomInterventions(String nomInterventions) {
        this.nomInterventions = nomInterventions;
    }

    public Integer getNombreIntervention() {
        return nombreIntervention;
    }

    public void setNombreIntervention(Integer nombreIntervention) {
        this.nombreIntervention = nombreIntervention;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Long getIdInfraction() {
        return idInfraction;
    }

    public void setIdInfraction(Long idInfraction) {
        this.idInfraction = idInfraction;
    }

    public Long getIdMad() {
        return idMad;
    }

    public void setIdMad(Long idMad) {
        this.idMad = idMad;
    }
}