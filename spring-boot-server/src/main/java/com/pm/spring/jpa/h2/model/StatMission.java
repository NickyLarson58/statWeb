package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stat_mission")
public class StatMission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stat_mission")
    private int idStatMission;

    @Column(name = "date_mission")
    private LocalDateTime dateMission;

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "idadresse", nullable = false)
    private Adresses lieuMission;

    @ManyToOne
    @JoinColumn(name = "id_mission", referencedColumnName = "id_mission", nullable = false)
    private Missions missions;

    @Column(name = "commerce")
    private String commerce;

    @Column(name = "duree_mission")
    private Integer dureeMission;

    @ManyToMany
    @JoinColumn(name = "matricule_agent_intervention", referencedColumnName = "matricule", nullable = false)
    private List<Agents> agents;

    public int getIdStatMission() {
        return idStatMission;
    }

    public void setIdStatMission(int idStatMission) {
        this.idStatMission = idStatMission;
    }

    public LocalDateTime getDateMission() {
        return dateMission;
    }

    public void setDateMission(LocalDateTime dateMission) {
        this.dateMission = dateMission;
    }

    public Adresses getLieuMission() {
        return lieuMission;
    }

    public void setLieuMission(Adresses lieuMission) {
        this.lieuMission = lieuMission;
    }

    public Missions getMissions() {
        return missions;
    }

    public void setMissions(Missions missions) {
        this.missions = missions;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public Integer getDureeMission() {
        return dureeMission;
    }

    public void setDureeMission(Integer dureeMission) {
        this.dureeMission = dureeMission;
    }

    public List<Agents> getAgents() {
        return agents;
    }

    public void setAgents(List<Agents> agents) {
        this.agents = agents;
    }
}