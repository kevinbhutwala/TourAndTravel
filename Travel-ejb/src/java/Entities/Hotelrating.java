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
@Table(name = "hotelrating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelrating.findAll", query = "SELECT h FROM Hotelrating h"),
    @NamedQuery(name = "Hotelrating.findByHotelratingId", query = "SELECT h FROM Hotelrating h WHERE h.hotelratingId = :hotelratingId"),
    @NamedQuery(name = "Hotelrating.findByRatingstar", query = "SELECT h FROM Hotelrating h WHERE h.ratingstar = :ratingstar"),
    @NamedQuery(name = "Hotelrating.findByDescription", query = "SELECT h FROM Hotelrating h WHERE h.description = :description")})
public class Hotelrating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelrating_id")
    private Integer hotelratingId;
    @Basic(optional = false)
    @Column(name = "ratingstar")
    private int ratingstar;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    @ManyToOne(optional = false)
    private Hotel hotelId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Hotelrating() {
    }

    public Hotelrating(Integer hotelratingId) {
        this.hotelratingId = hotelratingId;
    }

    public Hotelrating(Integer hotelratingId, int ratingstar, String description) {
        this.hotelratingId = hotelratingId;
        this.ratingstar = ratingstar;
        this.description = description;
    }

    public Integer getHotelratingId() {
        return hotelratingId;
    }

    public void setHotelratingId(Integer hotelratingId) {
        this.hotelratingId = hotelratingId;
    }

    public int getRatingstar() {
        return ratingstar;
    }

    public void setRatingstar(int ratingstar) {
        this.ratingstar = ratingstar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelratingId != null ? hotelratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelrating)) {
            return false;
        }
        Hotelrating other = (Hotelrating) object;
        if ((this.hotelratingId == null && other.hotelratingId != null) || (this.hotelratingId != null && !this.hotelratingId.equals(other.hotelratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hotelrating[ hotelratingId=" + hotelratingId + " ]";
    }
    
}
