package com.social.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Devis")
@Scope("session")
public class Devis {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long did ;



    @ManyToOne()
    @JoinColumn(name = "cid", nullable = false)
    private Consultation consultation ;

    @OneToOne
    @JoinColumn(name = "pid")
    private Provider provider;
@JsonIgnore
    @OneToOne()
    @JoinColumn(name = "procuctid")
    private Product product;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
