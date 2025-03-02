package com.pm.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intervention_agents")
public class InterventionAgents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricule_agent_intervention", referencedColumnName = "matricule", nullable = false)
    private Agents agent;

    @ManyToOne
    @JoinColumn(name = "id_stat_intervention", referencedColumnName = "id_stat_intervention", nullable = false)
    private StatIntervention statIntervention;

    public InterventionAgents() {
    }

    public InterventionAgents(Agents agent, StatIntervention statIntervention) {
        this.agent = agent;
        this.statIntervention = statIntervention;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agents getAgent() {
        return agent;
    }

    public void setAgent(Agents agent) {
        this.agent = agent;
    }

    public StatIntervention getStatIntervention() {
        return statIntervention;
    }

    public void setStatIntervention(StatIntervention statIntervention) {
        this.statIntervention = statIntervention;
    }
}