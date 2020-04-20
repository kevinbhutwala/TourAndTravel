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
@Table(name = "packagerating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packagerating.findAll", query = "SELECT p FROM Packagerating p"),
    @NamedQuery(name = "Packagerating.findByPackageratingId", query = "SELECT p FROM Packagerating p WHERE p.packageratingId = :packageratingId"),
    @NamedQuery(name = "Packagerating.findByRatingstar", query = "SELECT p FROM Packagerating p WHERE p.ratingstar = :ratingstar"),
    @NamedQuery(name = "Packagerating.findByDescription", query = "SELECT p FROM Packagerating p WHERE p.description = :description")})
public class Packagerating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "packagerating_id")
    private Integer packageratingId;
    @Basic(optional = false)
    @Column(name = "ratingstar")
    private int ratingstar;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne(optional = false)
    private Travelpackage packageId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Packagerating() {
    }

    public Packagerating(Integer packageratingId) {
        this.packageratingId = packageratingId;
    }

    public Packagerating(Integer packageratingId, int ratingstar, String description) {
        this.packageratingId = packageratingId;
        this.ratingstar = ratingstar;
        this.description = description;
    }

    public Integer getPackageratingId() {
        return packageratingId;
    }

    public void setPackageratingId(Integer packageratingId) {
        this.packageratingId = packageratingId;
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

    public Travelpackage getPackageId() {
        return packageId;
    }

    public void setPackageId(Travelpackage packageId) {
        this.packageId = packageId;
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
        hash += (packageratingId != null ? packageratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packagerating)) {
            return false;
        }
        Packagerating other = (Packagerating) object;
        if ((this.packageratingId == null && other.packageratingId != null) || (this.packageratingId != null && !this.packageratingId.equals(other.packageratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Packagerating[ packageratingId=" + packageratingId + " ]";
    }
    
}
