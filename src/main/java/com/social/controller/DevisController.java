package com.social.controller;

import com.social.dao.DevisRepository;
import com.social.entities.Devis;
import com.social.entities.User;
import com.social.services.ProviderService;
import com.social.services.UserService;
import com.social.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DevisController {


    @RestController
    @RequestMapping("account")
    @CrossOrigin(origins = "http://localhost:4200")

    public class AccountController {




        @Autowired

        private DevisRepository devisRepository;
        // request method to create a new account by a guest

        @CrossOrigin
        @RequestMapping(value = "/saveDevis", method = RequestMethod.POST)
        public ResponseEntity<?> createDevis(@RequestBody Devis newDevis) {


            return new ResponseEntity<Devis>(devisRepository.save(newDevis), HttpStatus.CREATED);
        }

    }
    }
