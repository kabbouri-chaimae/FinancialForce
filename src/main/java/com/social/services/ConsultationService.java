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
  public List<Consultation> find(String objet) {
        return consultationRepository.findByObjet(objet);
    }

    public Consultation update(Consultation co) {
        return consultationRepository.save(co);
    }

    public Consultation findById(Long id) {
        return consultationRepository.findByIdConsultation(id);
    }
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }
}