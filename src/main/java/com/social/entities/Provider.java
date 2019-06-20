package com.social.entities;


/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
/**
 * Description of User.
 *
 */
@Entity
@Table(name="Provider")
@Scope("session")
public  class Provider {

    /**
     * Description of the property id.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pid ;
    /**
     * Description of the property email.
     */
    @Column(unique = true)
    private String pname ;
    /**
     * Description of the property password.
     */

    private String pbankaccount ;
    /**
     * Description of the property role , to grant authority to the user .
     */
    private String  paddr;
    /**
     * Description of the property full name.
     */
    private String pcity;
    private String pcnss;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPbankaccount() {
        return pbankaccount;
    }

    public void setPbankaccount(String pbankaccount) {
        this.pbankaccount = pbankaccount;
    }

    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr;
    }

    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public String getPcnss() {
        return pcnss;
    }

    public void setPcnss(String pcnss) {
        this.pcnss = pcnss;
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Provider(){

    }

    public Provider(String pname, String pbankaccount, String paddr, String pcity, String pcnss) {
        this.pname = pname;
        this.pbankaccount = pbankaccount;
        this.paddr = paddr;
        this.pcity = pcity;
        this.pcnss = pcnss;
    }

    @Override
    public String toString() {
        return "U";
    }





}









