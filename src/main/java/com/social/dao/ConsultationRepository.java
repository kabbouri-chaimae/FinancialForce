package com.social.dao;

import com.social.entities.Consultation;
import com.social.entities.Devis;
import com.social.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    public Consultation findOneByObjet(String userName);

    public Consultation saveAndFlush(Consultation consultation);


    //@Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")
    // List<Provider> findByLastNameAndPhoneType(@Param("pType") String pType, @Param("lName") String lName);

}
