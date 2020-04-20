/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author misha
 */
@Entity
@Table(name = "offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferId", query = "SELECT o FROM Offer o WHERE o.offerId = :offerId"),
    @NamedQuery(name = "Offer.findByOfferName", query = "SELECT o FROM Offer o WHERE o.offerName = :offerName"),
    @NamedQuery(name = "Offer.findByIsspecial", query = "SELECT o FROM Offer o WHERE o.isspecial = :isspecial"),
    @NamedQuery(name = "Offer.findByDescription", query = "SELECT o FROM Offer o WHERE o.description = :description"),
    @NamedQuery(name = "Offer.findByImage", query = "SELECT o FROM Offer o WHERE o.image = :image")})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "offer_id")
    private Integer offerId;
    @Basic(optional = false)
    @Column(name = "offer_name")
    private String offerName;
    @Basic(optional = false)
    @Column(name = "isspecial")
    private boolean isspecial;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public Offer() {
    }

    public Offer(Integer offerId) {
        this.offerId = offerId;
    }

    public Offer(Integer offerId, String offerName, boolean isspecial, String description, String image) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.isspecial = isspecial;
        this.description = description;
        this.image = image;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public boolean getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(boolean isspecial) {
        this.isspecial = isspecial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerId != null ? offerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerId == null && other.offerId != null) || (this.offerId != null && !this.offerId.equals(other.offerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Offer[ offerId=" + offerId + " ]";
    }
    
}
