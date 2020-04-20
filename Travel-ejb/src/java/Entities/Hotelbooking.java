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
@Table(name = "hotelbooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelbooking.findAll", query = "SELECT h FROM Hotelbooking h"),
    @NamedQuery(name = "Hotelbooking.findByHotelbookingId", query = "SELECT h FROM Hotelbooking h WHERE h.hotelbookingId = :hotelbookingId"),
    @NamedQuery(name = "Hotelbooking.findByCheckinDate", query = "SELECT h FROM Hotelbooking h WHERE h.checkinDate = :checkinDate"),
    @NamedQuery(name = "Hotelbooking.findByCheckoutDate", query = "SELECT h FROM Hotelbooking h WHERE h.checkoutDate = :checkoutDate"),
    @NamedQuery(name = "Hotelbooking.findByAdultes", query = "SELECT h FROM Hotelbooking h WHERE h.adultes = :adultes"),
    @NamedQuery(name = "Hotelbooking.findByChildren", query = "SELECT h FROM Hotelbooking h WHERE h.children = :children"),
    @NamedQuery(name = "Hotelbooking.findByNoofrooms", query = "SELECT h FROM Hotelbooking h WHERE h.noofrooms = :noofrooms"),
    @NamedQuery(name = "Hotelbooking.findByBookingDate", query = "SELECT h FROM Hotelbooking h WHERE h.bookingDate = :bookingDate")})
public class Hotelbooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelbooking_id")
    private Integer hotelbookingId;
    @Basic(optional = false)
    @Column(name = "checkin_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkinDate;
    @Basic(optional = false)
    @Column(name = "checkout_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutDate;
    @Basic(optional = false)
    @Column(name = "Adultes")
    private int adultes;
    @Basic(optional = false)
    @Column(name = "Children")
    private int children;
    @Basic(optional = false)
    @Column(name = "noofrooms")
    private int noofrooms;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    @ManyToOne(optional = false)
    private Hotel hotelId;
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Hotelbooking() {
    }

    public Hotelbooking(Integer hotelbookingId) {
        this.hotelbookingId = hotelbookingId;
    }

    public Hotelbooking(Integer hotelbookingId, Date checkinDate, Date checkoutDate, int adultes, int children, int noofrooms, Date bookingDate) {
        this.hotelbookingId = hotelbookingId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.adultes = adultes;
        this.children = children;
        this.noofrooms = noofrooms;
        this.bookingDate = bookingDate;
    }

    public Integer getHotelbookingId() {
        return hotelbookingId;
    }

    public void setHotelbookingId(Integer hotelbookingId) {
        this.hotelbookingId = hotelbookingId;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getAdultes() {
        return adultes;
    }

    public void setAdultes(int adultes) {
        this.adultes = adultes;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(int noofrooms) {
        this.noofrooms = noofrooms;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelbookingId != null ? hotelbookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelbooking)) {
            return false;
        }
        Hotelbooking other = (Hotelbooking) object;
        if ((this.hotelbookingId == null && other.hotelbookingId != null) || (this.hotelbookingId != null && !this.hotelbookingId.equals(other.hotelbookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hotelbooking[ hotelbookingId=" + hotelbookingId + " ]";
    }
    
}
