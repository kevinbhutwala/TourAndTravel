/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author misha
 */
@Entity
@Table(name = "packagebooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packagebooking.findAll", query = "SELECT p FROM Packagebooking p"),
    @NamedQuery(name = "Packagebooking.findByPackagebookingId", query = "SELECT p FROM Packagebooking p WHERE p.packagebookingId = :packagebookingId"),
    @NamedQuery(name = "Packagebooking.findByNooftravelers", query = "SELECT p FROM Packagebooking p WHERE p.nooftravelers = :nooftravelers"),
    @NamedQuery(name = "Packagebooking.findByJourneystartDate", query = "SELECT p FROM Packagebooking p WHERE p.journeystartDate = :journeystartDate"),
    @NamedQuery(name = "Packagebooking.findByBookingDate", query = "SELECT p FROM Packagebooking p WHERE p.bookingDate = :bookingDate")})
public class Packagebooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "packagebooking_id")
    private Integer packagebookingId;
    @Basic(optional = false)
    @Column(name = "nooftravelers")
    private int nooftravelers;
    @Basic(optional = false)
    @Column(name = "journeystart_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date journeystartDate;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne(optional = false)
    private Travelpackage packageId;
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Packagebooking() {
    }

    public Packagebooking(Integer packagebookingId) {
        this.packagebookingId = packagebookingId;
    }

    public Packagebooking(Integer packagebookingId, int nooftravelers, Date journeystartDate, Date bookingDate) {
        this.packagebookingId = packagebookingId;
        this.nooftravelers = nooftravelers;
        this.journeystartDate = journeystartDate;
        this.bookingDate = bookingDate;
    }

    public Integer getPackagebookingId() {
        return packagebookingId;
    }

    public void setPackagebookingId(Integer packagebookingId) {
        this.packagebookingId = packagebookingId;
    }

    public int getNooftravelers() {
        return nooftravelers;
    }

    public void setNooftravelers(int nooftravelers) {
        this.nooftravelers = nooftravelers;
    }

    public Date getJourneystartDate() {
        return journeystartDate;
    }

    public void setJourneystartDate(Date journeystartDate) {
        this.journeystartDate = journeystartDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Travelpackage getPackageId() {
        return packageId;
    }

    public void setPackageId(Travelpackage packageId) {
        this.packageId = packageId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
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
        hash += (packagebookingId != null ? packagebookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packagebooking)) {
            return false;
        }
        Packagebooking other = (Packagebooking) object;
        if ((this.packagebookingId == null && other.packagebookingId != null) || (this.packagebookingId != null && !this.packagebookingId.equals(other.packagebookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Packagebooking[ packagebookingId=" + packagebookingId + " ]";
    }
    
}
