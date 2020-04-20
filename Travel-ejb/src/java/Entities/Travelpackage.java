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
@Table(name = "travelpackage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travelpackage.findAll", query = "SELECT t FROM Travelpackage t"),
    @NamedQuery(name = "Travelpackage.findByPackageId", query = "SELECT t FROM Travelpackage t WHERE t.packageId = :packageId"),
    @NamedQuery(name = "Travelpackage.findByPackageName", query = "SELECT t FROM Travelpackage t WHERE t.packageName = :packageName"),
    @NamedQuery(name = "Travelpackage.findByNoofdays", query = "SELECT t FROM Travelpackage t WHERE t.noofdays = :noofdays"),
    @NamedQuery(name = "Travelpackage.findByNoofnights", query = "SELECT t FROM Travelpackage t WHERE t.noofnights = :noofnights"),
    @NamedQuery(name = "Travelpackage.findByPackageCharge", query = "SELECT t FROM Travelpackage t WHERE t.packageCharge = :packageCharge"),
    @NamedQuery(name = "Travelpackage.findByCreatedDate", query = "SELECT t FROM Travelpackage t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Travelpackage.findByLastmodifyDate", query = "SELECT t FROM Travelpackage t WHERE t.lastmodifyDate = :lastmodifyDate"),
    @NamedQuery(name = "Travelpackage.findByDescription", query = "SELECT t FROM Travelpackage t WHERE t.description = :description")})
public class Travelpackage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "package_id")
    private Integer packageId;
    @Basic(optional = false)
    @Column(name = "package_name")
    private String packageName;
    @Basic(optional = false)
    @Column(name = "noofdays")
    private int noofdays;
    @Basic(optional = false)
    @Column(name = "noofnights")
    private int noofnights;
    @Basic(optional = false)
    @Column(name = "package_charge")
    private int packageCharge;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "lastmodify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifyDate;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "fromcity_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City fromcityId;
    @JoinColumn(name = "tocity_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City tocityId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private State stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Packagebooking> packagebookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Packagerating> packageratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Packageimage> packageimageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Cancelbooking> cancelbookingCollection;

    public Travelpackage() {
    }

    public Travelpackage(Integer packageId) {
        this.packageId = packageId;
    }

    public Travelpackage(Integer packageId, String packageName, int noofdays, int noofnights, int packageCharge) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.noofdays = noofdays;
        this.noofnights = noofnights;
        this.packageCharge = packageCharge;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(int noofdays) {
        this.noofdays = noofdays;
    }

    public int getNoofnights() {
        return noofnights;
    }

    public void setNoofnights(int noofnights) {
        this.noofnights = noofnights;
    }

    public int getPackageCharge() {
        return packageCharge;
    }

    public void setPackageCharge(int packageCharge) {
        this.packageCharge = packageCharge;
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public City getFromcityId() {
        return fromcityId;
    }

    public void setFromcityId(City fromcityId) {
        this.fromcityId = fromcityId;
    }

    public City getTocityId() {
        return tocityId;
    }

    public void setTocityId(City tocityId) {
        this.tocityId = tocityId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    @XmlTransient
    public Collection<Packagebooking> getPackagebookingCollection() {
        return packagebookingCollection;
    }

    public void setPackagebookingCollection(Collection<Packagebooking> packagebookingCollection) {
        this.packagebookingCollection = packagebookingCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Packagerating> getPackageratingCollection() {
        return packageratingCollection;
    }

    public void setPackageratingCollection(Collection<Packagerating> packageratingCollection) {
        this.packageratingCollection = packageratingCollection;
    }

    @XmlTransient
    public Collection<Packageimage> getPackageimageCollection() {
        return packageimageCollection;
    }

    public void setPackageimageCollection(Collection<Packageimage> packageimageCollection) {
        this.packageimageCollection = packageimageCollection;
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
        hash += (packageId != null ? packageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travelpackage)) {
            return false;
        }
        Travelpackage other = (Travelpackage) object;
        if ((this.packageId == null && other.packageId != null) || (this.packageId != null && !this.packageId.equals(other.packageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Travelpackage[ packageId=" + packageId + " ]";
    }
    
}
