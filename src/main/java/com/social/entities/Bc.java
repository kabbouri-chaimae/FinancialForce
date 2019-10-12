

package com.social.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;



@Entity
@Table(name="Bc")
@Scope("session")
public class Bc {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBC;
    @OneToOne
    @JoinColumn()
    private Consultation consultation;

    private int Qty;
    private int TVA;
    private String Exercice;
    private int  Budget ;
    private String  PAR;
    private String LRG;
    private String Ligne;

    public Long getIdBC() {
        return idBC;
    }

    public void setIdBC(Long idBC) {
        this.idBC = idBC;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getExercice() {
        return Exercice;
    }

    public void setExercice(String exercice) {
        Exercice = exercice;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public String getPAR() {
        return PAR;
    }

    public void setPAR(String PAR) {
        this.PAR = PAR;
    }

    public String getLRG() {
        return LRG;
    }

    public void setLRG(String LRG) {
        this.LRG = LRG;
    }

    public String getLigne() {
        return Ligne;
    }

    public void setLigne(String ligne) {
        Ligne = ligne;
    }

    public int getTVA() {
        return TVA;
    }

    public void setTVA(int TVA) {
        this.TVA = TVA;
    }

    public Bc(Consultation consultation, int qty, int TVA, String exercice, int budget, String PAR, String LRG, String ligne) {
        this.consultation = consultation;
        Qty = qty;
        this.TVA = TVA;
        Exercice = exercice;
        Budget = budget;
        this.PAR = PAR;
        this.LRG = LRG;
        Ligne = ligne;
    }

    public Bc() {
    }
}