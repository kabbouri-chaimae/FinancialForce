package com.social.dao;

import com.social.entities.Bc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BcRepository extends JpaRepository<Bc, Long>{

    public Bc saveAndFlush(Bc bc);


    //@Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")

    // List<Provider> findByLastNameAndPhoneType(@Param("pType") String pType, @Param("lName") String lName);

}
