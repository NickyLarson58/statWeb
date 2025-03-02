package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mission_agents")
public class MissionAgents {
    @Id
    @ManyToOne
    @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule", nullable = false)
    private Agents agent;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_stat_mission", referencedColumnName = "id_stat_mission", nullable = false)
    private StatMission statMission;

    public MissionAgents() {
    }

    public MissionAgents(Agents agent, StatMission statMission) {
        this.agent = agent;
        this.statMission = statMission;
    }

    public Agents getAgent() {
        return agent;
    }

    public void setAgent(Agents agent) {
        this.agent = agent;
    }

    public StatMission getStatMission() {
        return statMission;
    }

    public void setStatMission(StatMission statMission) {
        this.statMission = statMission;
    }
}