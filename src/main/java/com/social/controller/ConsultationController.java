package com.social.controller;

import com.social.dao.ConsultationRepository;
import com.social.dao.DevisRepository;
import com.social.entities.Consultation;
import com.social.entities.Devis;
import com.social.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




    @RestController
    @RequestMapping("accountt")
    @CrossOrigin(origins = "http://localhost:4200")


    public class ConsultationController {



        @Autowired

        private ConsultationService consultationService;
        // request method to create a new account by a guest



    }
