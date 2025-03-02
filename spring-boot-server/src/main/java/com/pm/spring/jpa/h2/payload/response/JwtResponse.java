package com.pm.spring.jpa.h2.payload.response;

public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;

    public JwtResponse(String accessToken, Long id, String matricule, String nom, String prenom) {
        this.accessToken = accessToken;
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}