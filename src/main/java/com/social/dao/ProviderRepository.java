package com.social.dao;

import com.social.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


/* this the user  Repository interface  */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    public Provider findOneByPname(String proname);

    //@Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")
   // List<Provider> findByLastNameAndPhoneType(@Param("pType") String pType, @Param("lName") String lName);

}
