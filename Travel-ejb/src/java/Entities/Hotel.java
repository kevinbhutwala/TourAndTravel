/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author misha
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByHotelId", query = "SELECT h FROM Hotel h WHERE h.hotelId = :hotelId"),
    @NamedQuery(name = "Hotel.findByHotelName", query = "SELECT h FROM Hotel h WHERE h.hotelName = :hotelName"),
    @NamedQuery(name = "Hotel.findByCreatedDate", query = "SELECT h FROM Hotel h WHERE h.createdDate = :createdDate"),
    @NamedQuery(name = "Hotel.findByLastmodifyDate", query = "SELECT h FROM Hotel h WHERE h.lastmodifyDate = :lastmodifyDate"),
    @NamedQuery(name = "Hotel.findByDescription", query = "SELECT h FROM Hotel h WHERE h.description = :description")})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Basic(optional = false)
    @Column(name = "hotel_name")
    private String hotelName;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "lastmodify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifyDate;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Hotelrating> hotelratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Hotelimage> hotelimageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Hotelfood> hotelfoodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Hotelbooking> hotelbookingCollection;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;
    @JoinColumn(name = "roomtype_id", referencedColumnName = "roomtype_id")
    @ManyToOne(optional = false)
    private Roomtype roomtypeId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private State stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<Cancelbooking> cancelbookingCollection;

    public Hotel() {
    }

    public Hotel(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel(Integer hotelId, String hotelName, Date createdDate, Date lastmodifyDate, String description) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.createdDate = createdDate;
        this.lastmodifyDate = lastmodifyDate;
        this.description = description;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastmodifyDate() {
        return lastmodifyDate;
    }

    public void setLastmodifyDate(Date lastmodifyDate) {
        this.lastmodifyDate = lastmodifyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Hotelrating> getHotelratingCollection() {
        return hotelratingCollection;
    }

    public void setHotelratingCollection(Collection<Hotelrating> hotelratingCollection) {
        this.hotelratingCollection = hotelratingCollection;
    }

    @XmlTransient
    public Collection<Hotelimage> getHotelimageCollection() {
        return hotelimageCollection;
    }

    public void setHotelimageCollection(Collection<Hotelimage> hotelimageCollection) {
        this.hotelimageCollection = hotelimageCollection;
    }

    @XmlTransient
    public Collection<Hotelfood> getHotelfoodCollection() {
        return hotelfoodCollection;
    }

    public void setHotelfoodCollection(Collection<Hotelfood> hotelfoodCollection) {
        this.hotelfoodCollection = hotelfoodCollection;
    }

    @XmlTransient
    public Collection<Hotelbooking> getHotelbookingCollection() {
        return hotelbookingCollection;
    }

    public void setHotelbookingCollection(Collection<Hotelbooking> hotelbookingCollection) {
        this.hotelbookingCollection = hotelbookingCollection;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public Roomtype getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(Roomtype roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Cancelbooking> getCancelbookingCollection() {
        return cancelbookingCollection;
    }

    public void setCancelbookingCollection(Collection<Cancelbooking> cancelbookingCollection) {
        this.cancelbookingCollection = cancelbookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hotel[ hotelId=" + hotelId + " ]";
    }
    
}
