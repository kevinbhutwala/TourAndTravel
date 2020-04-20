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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author misha
 */
@Entity
@Table(name = "hotelfood")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelfood.findAll", query = "SELECT h FROM Hotelfood h"),
    @NamedQuery(name = "Hotelfood.findByHotelfoodId", query = "SELECT h FROM Hotelfood h WHERE h.hotelfoodId = :hotelfoodId"),
    @NamedQuery(name = "Hotelfood.findByFoodCharge", query = "SELECT h FROM Hotelfood h WHERE h.foodCharge = :foodCharge")})
public class Hotelfood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelfood_id")
    private Integer hotelfoodId;
    @Basic(optional = false)
    @Column(name = "food_charge")
    private int foodCharge;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne(optional = false)
    private Food foodId;
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    @ManyToOne(optional = false)
    private Hotel hotelId;

    public Hotelfood() {
    }

    public Hotelfood(Integer hotelfoodId) {
        this.hotelfoodId = hotelfoodId;
    }

    public Hotelfood(Integer hotelfoodId, int foodCharge) {
        this.hotelfoodId = hotelfoodId;
        this.foodCharge = foodCharge;
    }

    public Integer getHotelfoodId() {
        return hotelfoodId;
    }

    public void setHotelfoodId(Integer hotelfoodId) {
        this.hotelfoodId = hotelfoodId;
    }

    public int getFoodCharge() {
        return foodCharge;
    }

    public void setFoodCharge(int foodCharge) {
        this.foodCharge = foodCharge;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelfoodId != null ? hotelfoodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelfood)) {
            return false;
        }
        Hotelfood other = (Hotelfood) object;
        if ((this.hotelfoodId == null && other.hotelfoodId != null) || (this.hotelfoodId != null && !this.hotelfoodId.equals(other.hotelfoodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hotelfood[ hotelfoodId=" + hotelfoodId + " ]";
    }
    
}
