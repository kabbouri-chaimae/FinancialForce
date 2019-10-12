package com.social.services;

import com.social.dao.BcRepository;
import com.social.dao.ConsultationRepository;
import com.social.entities.Bc;
import com.social.entities.Consultation;
import com.social.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.UserRepository;
import com.social.entities.User;

import java.util.List;


@Service
public class BcService {

    @Autowired
    BcRepository bcRepository;

    public Bc save(Bc bc) {
        return bcRepository.saveAndFlush(bc);
    }

}