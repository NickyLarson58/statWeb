package com.pm.spring.jpa.h2.payload;

import com.pm.spring.jpa.h2.model.Agents;

import java.time.LocalDateTime;
import java.util.List;

public class CreatedStatMissionDTO {
    private Long idMission;
    private LocalDateTime dateMission;
    private String nomMission;
    private int duree;
    private String commerce;
    private Long idAdresse;
    private List<Agents> agents;

    // Getters and Setters
    public Long getIdMission() {
        return idMission;
    }

    public void setIdMission(Long idMission) {
        this.idMission = idMission;
    }

    public LocalDateTime getDateMission() {
        return dateMission;
    }

    public void setDateMission(LocalDateTime dateMission) {
        this.dateMission = dateMission;
    }

    public String getNomMission() {
        return nomMission;
    }

    public void setNomMission(String nomMission) {
        this.nomMission = nomMission;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public List<Agents> getAgents() {
        return agents;
    }

    public void setAgents(List<Agents> agents) {
        this.agents = agents;
    }
}