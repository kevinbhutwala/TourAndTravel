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
@Table(name = "advertisementimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisementimage.findAll", query = "SELECT a FROM Advertisementimage a"),
    @NamedQuery(name = "Advertisementimage.findByAdvimageId", query = "SELECT a FROM Advertisementimage a WHERE a.advimageId = :advimageId"),
    @NamedQuery(name = "Advertisementimage.findByAdvImage", query = "SELECT a FROM Advertisementimage a WHERE a.advImage = :advImage")})
public class Advertisementimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "advimage_id")
    private Integer advimageId;
    @Basic(optional = false)
    @Column(name = "adv_image")
    private String advImage;
    @JoinColumn(name = "adv_id", referencedColumnName = "adv_id")
    @ManyToOne(optional = false)
    private Advertisement advId;

    public Advertisementimage() {
    }

    public Advertisementimage(Integer advimageId) {
        this.advimageId = advimageId;
    }

    public Advertisementimage(Integer advimageId, String advImage) {
        this.advimageId = advimageId;
        this.advImage = advImage;
    }

    public Integer getAdvimageId() {
        return advimageId;
    }

    public void setAdvimageId(Integer advimageId) {
        this.advimageId = advimageId;
    }

    public String getAdvImage() {
        return advImage;
    }

    public void setAdvImage(String advImage) {
        this.advImage = advImage;
    }

    public Advertisement getAdvId() {
        return advId;
    }

    public void setAdvId(Advertisement advId) {
        this.advId = advId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advimageId != null ? advimageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisementimage)) {
            return false;
        }
        Advertisementimage other = (Advertisementimage) object;
        if ((this.advimageId == null && other.advimageId != null) || (this.advimageId != null && !this.advimageId.equals(other.advimageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Advertisementimage[ advimageId=" + advimageId + " ]";
    }
    
}
