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
@Table(name = "hotelimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelimage.findAll", query = "SELECT h FROM Hotelimage h"),
    @NamedQuery(name = "Hotelimage.findByHotelimageId", query = "SELECT h FROM Hotelimage h WHERE h.hotelimageId = :hotelimageId"),
    @NamedQuery(name = "Hotelimage.findByHotelImage", query = "SELECT h FROM Hotelimage h WHERE h.hotelImage = :hotelImage")})
public class Hotelimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelimage_id")
    private Integer hotelimageId;
    @Basic(optional = false)
    @Column(name = "hotel_image")
    private String hotelImage;
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    @ManyToOne(optional = false)
    private Hotel hotelId;

    public Hotelimage() {
    }

    public Hotelimage(Integer hotelimageId) {
        this.hotelimageId = hotelimageId;
    }

    public Hotelimage(Integer hotelimageId, String hotelImage) {
        this.hotelimageId = hotelimageId;
        this.hotelImage = hotelImage;
    }

    public Integer getHotelimageId() {
        return hotelimageId;
    }

    public void setHotelimageId(Integer hotelimageId) {
        this.hotelimageId = hotelimageId;
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
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
        hash += (hotelimageId != null ? hotelimageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelimage)) {
            return false;
        }
        Hotelimage other = (Hotelimage) object;
        if ((this.hotelimageId == null && other.hotelimageId != null) || (this.hotelimageId != null && !this.hotelimageId.equals(other.hotelimageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hotelimage[ hotelimageId=" + hotelimageId + " ]";
    }
    
}
