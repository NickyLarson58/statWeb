package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "missions")
public class Missions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mission")
    private int idMission;

    @Column(name = "nom_mission")
    private String nomMission;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getNomMission() {
        return nomMission;
    }

    public void setNomMission(String nomMission) {
        this.nomMission = nomMission;
    }
}
