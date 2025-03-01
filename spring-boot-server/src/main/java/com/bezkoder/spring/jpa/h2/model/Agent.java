package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricule;

    @Column(name = "nomAgent")
    private String nomAgent;

    @Column(name = "prenomAgent")
    private String prenomAgent;

    @Column(name = "brigade")
    private String brigade;

    @Column(name = "mdp")
    private int mdp;

    @Column(name = "pouvoir")
    private String pouvoir;

    @Column(name = "secteur")
    private String secteur;

    public Agent() {
    }

    public Agent(String nomAgent, String prenomAgent, String brigade, int mdp, String pouvoir, String secteur) {
        this.nomAgent = nomAgent;
        this.prenomAgent = prenomAgent;
        this.brigade = brigade;
        this.mdp = mdp;
        this.pouvoir = pouvoir;
        this.secteur = secteur;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public void setPrenomAgent(String prenomAgent) {
        this.prenomAgent = prenomAgent;
    }

    public String getBrigade() {
        return brigade;
    }

    public void setBrigade(String brigade) {
        this.brigade = brigade;
    }

    public int getMdp() {
        return mdp;
    }

    public void setMdp(int mdp) {
        this.mdp = mdp;
    }

    public String getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(String pouvoir) {
        this.pouvoir = pouvoir;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Agent [matricule=" + matricule 
                + ", nomAgent=" + nomAgent 
                + ", prenomAgent=" + prenomAgent 
                + ", brigade=" + brigade 
                + ", mdp=" + mdp 
                + ", pouvoir=" + pouvoir 
                + ", secteur=" + secteur + "]";
    }
}