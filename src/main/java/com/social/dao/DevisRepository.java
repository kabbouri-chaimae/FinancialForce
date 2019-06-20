package com.social.dao;

import com.social.entities.Devis;
import com.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface DevisRepository extends JpaRepository<Devis, Long> {

    public Devis findByDid(Long id);




    }





