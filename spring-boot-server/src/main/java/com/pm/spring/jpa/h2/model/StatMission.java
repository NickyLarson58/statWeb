package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stat_mission")
public class StatMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stat_mission")
    private int id_stat_mission;

    @Column(name = "date_mission")
    private LocalDateTime date_mission;

    @Column(name = "lieu_mission", length = 45)
    private String lieu_mission;

    @ManyToOne
    @JoinColumn(name = "id_mission", referencedColumnName = "id_mission", nullable = false)
    private Missions missions;

    @Column(name = "commerce")
    private Integer commerce;

    @Column(name = "duree_mission")
    private Integer duree_mission;

    // Getters and Setters
    public int getId_stat_mission() {
        return id_stat_mission;
    }

    public void setId_stat_mission(int id_stat_mission) {
        this.id_stat_mission = id_stat_mission;
    }

    public LocalDateTime getDate_mission() {
        return date_mission;
    }

    public void setDate_mission(LocalDateTime date_mission) {
        this.date_mission = date_mission;
    }

    public String getLieu_mission() {
        return lieu_mission;
    }

    public void setLieu_mission(String lieu_mission) {
        this.lieu_mission = lieu_mission;
    }

    public Missions getMission() {
        return missions;
    }

    public void setMission(Missions mission) {
        this.missions = mission;
    }

    public Integer getCommerce() {
        return commerce;
    }

    public void setCommerce(Integer commerce) {
        this.commerce = commerce;
    }

    public Integer getDuree_mission() {
        return duree_mission;
    }

    public void setDuree_mission(Integer duree_mission) {
        this.duree_mission = duree_mission;
    }
}