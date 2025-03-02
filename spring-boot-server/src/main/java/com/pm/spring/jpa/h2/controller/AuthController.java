package com.pm.spring.jpa.h2.controller;

import com.pm.spring.jpa.h2.model.Agents;
import com.pm.spring.jpa.h2.repository.AgentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AgentsRepository agentsRepository;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {

            Optional<Agents> agent = agentsRepository.findAgentsByMatriculeAndMdp(loginRequest.getMatricule(), loginRequest.getPassword());

            if (agent.isPresent()) {
                LoginResponse response = new LoginResponse(
                    agent.get().getMatricule(),
                    agent.get().getNomAgent(),
                    agent.get().getPrenomAgent(),
                    agent.get().getPouvoir(),
                    agent.get().getSecteur(),
                    agent.get().getBrigade()
                );
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error during authentication");
        }
    }
}

class LoginRequest {
    private int matricule;
    private int password;

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

class LoginResponse {
    private int id;
    private String nomAgent;
    private String prenomAgent;
    private String pouvoir;
    private String secteur;
    private String brigade;

    public LoginResponse(int matricule, String nomAgent, String prenomAgent,
                        String pouvoir, String secteur, String brigade) {
        this.id = matricule;
        this.nomAgent = nomAgent;
        this.prenomAgent = prenomAgent;
        this.pouvoir = pouvoir;
        this.secteur = secteur;
        this.brigade = brigade;
    }

    public int getId() {
        return id;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public String getPouvoir() {
        return pouvoir;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getBrigade() {
        return brigade;
    }
}