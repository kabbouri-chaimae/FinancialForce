package com.social.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Consultation")
@Scope("session")
public class Consultation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idConsultation ;


    @OneToOne
    @JoinColumn()
    private Provider fournisseurList;



    private String objet;

    private String message;

  private String dateCreation;
  private String lieuConsultation;

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }


    public String getObjet() {
        return objet;
    }

    public void setObject(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLieuConsultation() {
        return lieuConsultation;
    }

    public void setLieuConsultation(String lieuConsultation) {
        this.lieuConsultation = lieuConsultation;
    }

    public Provider getFournisseurList() {
        return fournisseurList;
    }

    public void setFournisseurList(Provider fournisseurList) {
        this.fournisseurList = fournisseurList;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }
    @JsonCreator
    public Consultation(@JsonProperty("fournisseurList") Provider fournisseurList, @JsonProperty("objet") String objet, @JsonProperty("message") String message, @JsonProperty("dateCreation") String dateCreation, @JsonProperty("lieuConsultation")String lieuConsultation) {
        this.fournisseurList = fournisseurList;
        this.objet = objet;
        this.message = message;
        this.dateCreation = dateCreation;
        this.lieuConsultation = lieuConsultation;
    }

    public Consultation() {
    }
}
