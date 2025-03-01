package com.bezkoder.spring.jpa.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jpa.h2.model.Agent;
import com.bezkoder.spring.jpa.h2.repository.AgentsRepository;
import com.bezkoder.spring.jpa.h2.payload.request.LoginRequest;
import com.bezkoder.spring.jpa.h2.payload.response.JwtResponse;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AgentsRepository agentRepository;

    @Autowired
    PasswordEncoder encoder;

}