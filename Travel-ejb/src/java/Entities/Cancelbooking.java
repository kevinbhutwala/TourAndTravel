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
@Table(name = "cancelbooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancelbooking.findAll", query = "SELECT c FROM Cancelbooking c"),
    @NamedQuery(name = "Cancelbooking.findByCancelbookingId", query = "SELECT c FROM Cancelbooking c WHERE c.cancelbookingId = :cancelbookingId"),
    @NamedQuery(name = "Cancelbooking.findByReasonForCancel", query = "SELECT c FROM Cancelbooking c WHERE c.reasonForCancel = :reasonForCancel"),
    @NamedQuery(name = "Cancelbooking.findByDate", query = "SELECT c FROM Cancelbooking c WHERE c.date = :date")})
public class Cancelbooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cancelbooking_id")
    private Integer cancelbookingId;
    @Basic(optional = false)
    @Column(name = "reason_for_cancel")
    private String reasonForCancel;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    @ManyToOne(optional = false)
    private Hotel hotelId;
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne(optional = false)
    private Travelpackage packageId;

    public Cancelbooking() {
    }

    public Cancelbooking(Integer cancelbookingId) {
        this.cancelbookingId = cancelbookingId;
    }

    public Cancelbooking(Integer cancelbookingId, String reasonForCancel, Date date) {
        this.cancelbookingId = cancelbookingId;
        this.reasonForCancel = reasonForCancel;
        this.date = date;
    }

    public Integer getCancelbookingId() {
        return cancelbookingId;
    }

    public void setCancelbookingId(Integer cancelbookingId) {
        this.cancelbookingId = cancelbookingId;
    }

    public String getReasonForCancel() {
        return reasonForCancel;
    }

    public void setReasonForCancel(String reasonForCancel) {
        this.reasonForCancel = reasonForCancel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
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

    public Travelpackage getPackageId() {
        return packageId;
    }

    public void setPackageId(Travelpackage packageId) {
        this.packageId = packageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancelbookingId != null ? cancelbookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancelbooking)) {
            return false;
        }
        Cancelbooking other = (Cancelbooking) object;
        if ((this.cancelbookingId == null && other.cancelbookingId != null) || (this.cancelbookingId != null && !this.cancelbookingId.equals(other.cancelbookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Cancelbooking[ cancelbookingId=" + cancelbookingId + " ]";
    }
    
}
