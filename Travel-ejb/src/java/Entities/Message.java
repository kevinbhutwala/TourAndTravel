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
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessageId", query = "SELECT m FROM Message m WHERE m.messageId = :messageId"),
    @NamedQuery(name = "Message.findByMessageText", query = "SELECT m FROM Message m WHERE m.messageText = :messageText"),
    @NamedQuery(name = "Message.findByIsread", query = "SELECT m FROM Message m WHERE m.isread = :isread")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id")
    private Integer messageId;
    @Basic(optional = false)
    @Column(name = "message_text")
    private String messageText;
    @Basic(optional = false)
    @Column(name = "isread")
    private boolean isread;
    @JoinColumn(name = "from_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User fromUserId;
    @JoinColumn(name = "to_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User toUserId;

    public Message() {
    }

    public Message(Integer messageId) {
        this.messageId = messageId;
    }

    public Message(Integer messageId, String messageText, boolean isread) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.isread = isread;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean getIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public User getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(User fromUserId) {
        this.fromUserId = fromUserId;
    }

    public User getToUserId() {
        return toUserId;
    }

    public void setToUserId(User toUserId) {
        this.toUserId = toUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Message[ messageId=" + messageId + " ]";
    }
    
}
