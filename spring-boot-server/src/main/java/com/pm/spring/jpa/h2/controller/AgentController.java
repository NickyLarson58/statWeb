package com.pm.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pm.spring.jpa.h2.model.Agents;
import com.pm.spring.jpa.h2.repository.AgentsRepository;

@RestController
@RequestMapping("/api")
public class AgentController {

    @Autowired
    AgentsRepository agentsRepository;

    @GetMapping("/agents")
    public ResponseEntity<List<Agents>> getAllAgents() {
        try {
            List<Agents> agents = agentsRepository.findAll();
            if (agents.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(agents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/agents/{id}")
    public ResponseEntity<Agents> getAgentById(@PathVariable("id") long id) {
        Optional<Agents> agentData = agentsRepository.findById(id);
        if (agentData.isPresent()) {
            return new ResponseEntity<>(agentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agents")
    public ResponseEntity<Agents> createAgent(@RequestBody Agents agent) {
        try {
            Agents _agent = agentsRepository.save(agent);
            return new ResponseEntity<>(_agent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/agents/{id}")
    public ResponseEntity<Agents> updateAgent(@PathVariable("id") long id, @RequestBody Agents agent) {
        Optional<Agents> agentData = agentsRepository.findById(id);
        if (agentData.isPresent()) {
            Agents _agent = agentData.get();
            _agent.setNomAgent(agent.getNomAgent());
            _agent.setPrenomAgent(agent.getPrenomAgent());
            _agent.setBrigade(agent.getBrigade());
            _agent.setMdp(agent.getMdp());
            _agent.setPouvoir(agent.getPouvoir());
            _agent.setSecteur(agent.getSecteur());
            return new ResponseEntity<>(agentsRepository.save(_agent), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/agents/{id}")
    public ResponseEntity<HttpStatus> deleteAgent(@PathVariable("id") long id) {
        try {
            agentsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/agents")
    public ResponseEntity<HttpStatus> deleteAllAgents() {
        try {
            agentsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}