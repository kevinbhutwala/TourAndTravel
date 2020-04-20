/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author misha
 */
@Entity
@Table(name = "roomtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findByRoomtypeId", query = "SELECT r FROM Roomtype r WHERE r.roomtypeId = :roomtypeId"),
    @NamedQuery(name = "Roomtype.findByRoomtypeName", query = "SELECT r FROM Roomtype r WHERE r.roomtypeName = :roomtypeName"),
    @NamedQuery(name = "Roomtype.findByRoomcharge", query = "SELECT r FROM Roomtype r WHERE r.roomcharge = :roomcharge"),
    @NamedQuery(name = "Roomtype.findByDescription", query = "SELECT r FROM Roomtype r WHERE r.description = :description")})
public class Roomtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roomtype_id")
    private Integer roomtypeId;
    @Basic(optional = false)
    @Column(name = "roomtype_name")
    private String roomtypeName;
    @Basic(optional = false)
    @Column(name = "roomcharge")
    private int roomcharge;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomtypeId")
    private Collection<Hotel> hotelCollection;

    public Roomtype() {
    }

    public Roomtype(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public Roomtype(Integer roomtypeId, String roomtypeName, int roomcharge, String description) {
        this.roomtypeId = roomtypeId;
        this.roomtypeName = roomtypeName;
        this.roomcharge = roomcharge;
        this.description = description;
    }

    public Integer getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public String getRoomtypeName() {
        return roomtypeName;
    }

    public void setRoomtypeName(String roomtypeName) {
        this.roomtypeName = roomtypeName;
    }

    public int getRoomcharge() {
        return roomcharge;
    }

    public void setRoomcharge(int roomcharge) {
        this.roomcharge = roomcharge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Hotel> getHotelCollection() {
        return hotelCollection;
    }

    public void setHotelCollection(Collection<Hotel> hotelCollection) {
        this.hotelCollection = hotelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomtypeId != null ? roomtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.roomtypeId == null && other.roomtypeId != null) || (this.roomtypeId != null && !this.roomtypeId.equals(other.roomtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Roomtype[ roomtypeId=" + roomtypeId + " ]";
    }
    
}
