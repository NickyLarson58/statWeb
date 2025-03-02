package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "missions")
public class Missions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mission;

    @Column(name = "nom_mission")
    private String nomMission;

    public int getId_mission() {
        return id_mission;
    }

    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }

    public String getNomMission() {
        return nomMission;
    }

    public void setNomMission(String nomMission) {
        this.nomMission = nomMission;
    }
}
