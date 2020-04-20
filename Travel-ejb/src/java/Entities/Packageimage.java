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
@Table(name = "packageimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packageimage.findAll", query = "SELECT p FROM Packageimage p"),
    @NamedQuery(name = "Packageimage.findByPackageimageId", query = "SELECT p FROM Packageimage p WHERE p.packageimageId = :packageimageId"),
    @NamedQuery(name = "Packageimage.findByPackageImage", query = "SELECT p FROM Packageimage p WHERE p.packageImage = :packageImage")})
public class Packageimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "packageimage_id")
    private Integer packageimageId;
    @Basic(optional = false)
    @Column(name = "package_image")
    private String packageImage;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne(optional = false)
    private Travelpackage packageId;

    public Packageimage() {
    }

    public Packageimage(Integer packageimageId) {
        this.packageimageId = packageimageId;
    }

    public Packageimage(Integer packageimageId, String packageImage) {
        this.packageimageId = packageimageId;
        this.packageImage = packageImage;
    }

    public Integer getPackageimageId() {
        return packageimageId;
    }

    public void setPackageimageId(Integer packageimageId) {
        this.packageimageId = packageimageId;
    }

    public String getPackageImage() {
        return packageImage;
    }

    public void setPackageImage(String packageImage) {
        this.packageImage = packageImage;
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
        hash += (packageimageId != null ? packageimageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packageimage)) {
            return false;
        }
        Packageimage other = (Packageimage) object;
        if ((this.packageimageId == null && other.packageimageId != null) || (this.packageimageId != null && !this.packageimageId.equals(other.packageimageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Packageimage[ packageimageId=" + packageimageId + " ]";
    }
    
}
