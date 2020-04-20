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
@Table(name = "advertisement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a"),
    @NamedQuery(name = "Advertisement.findByAdvId", query = "SELECT a FROM Advertisement a WHERE a.advId = :advId"),
    @NamedQuery(name = "Advertisement.findByAdvTitle", query = "SELECT a FROM Advertisement a WHERE a.advTitle = :advTitle"),
    @NamedQuery(name = "Advertisement.findByCompanyName", query = "SELECT a FROM Advertisement a WHERE a.companyName = :companyName"),
    @NamedQuery(name = "Advertisement.findByDescription", query = "SELECT a FROM Advertisement a WHERE a.description = :description")})
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adv_id")
    private Integer advId;
    @Basic(optional = false)
    @Column(name = "adv_title")
    private String advTitle;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advId")
    private Collection<Advertisementimage> advertisementimageCollection;

    public Advertisement() {
    }

    public Advertisement(Integer advId) {
        this.advId = advId;
    }

    public Advertisement(Integer advId, String advTitle, String companyName, String description) {
        this.advId = advId;
        this.advTitle = advTitle;
        this.companyName = companyName;
        this.description = description;
    }

    public Integer getAdvId() {
        return advId;
    }

    public void setAdvId(Integer advId) {
        this.advId = advId;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Advertisementimage> getAdvertisementimageCollection() {
        return advertisementimageCollection;
    }

    public void setAdvertisementimageCollection(Collection<Advertisementimage> advertisementimageCollection) {
        this.advertisementimageCollection = advertisementimageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advId != null ? advId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.advId == null && other.advId != null) || (this.advId != null && !this.advId.equals(other.advId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Advertisement[ advId=" + advId + " ]";
    }
    
}
