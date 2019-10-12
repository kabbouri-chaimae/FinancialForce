package com.social.controller;

import com.social.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




    @RestController
    @RequestMapping("accountt")
    @CrossOrigin(origins = "http://localhost:4200")


    public class ConsultationController {



        @Autowired

        private ConsultationService consultationService;
        // request method to create a new account by a guest



    }
