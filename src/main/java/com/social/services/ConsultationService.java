package com.social.services;

import com.social.dao.ConsultationRepository;
import com.social.entities.Consultation;
import com.social.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.UserRepository;
import com.social.entities.User;

import java.util.List;


@Service
public class ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;

    public Consultation save(Consultation co) {
        return consultationRepository.saveAndFlush(co);
    }
  public Consultation find(String objet) {
        return consultationRepository.findOneByObjet(objet);
    }

    public Consultation update(Consultation co) {
        return consultationRepository.save(co);

    }
}