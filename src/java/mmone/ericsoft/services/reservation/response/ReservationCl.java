/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Reservation",namespace = "http://response.reservation.services.ericsoft.mmone")
public class ReservationCl {
    private String id;
    private float totalPrice;
    private Date creationDate;
    private Date lastChangeDate;

    @XmlAttribute(name="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "TotalPrice")
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement(name="CreationDate")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @XmlElement(name="LastChangeDate")
    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @XmlElement(name="State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    private String state;
    
    private BookerCl booker;
    @XmlElement(name="Booker")
    public BookerCl getBooker() {
        return booker;
    }

    public void setBooker(BookerCl booker) {
        this.booker = booker;
    }
    @XmlElement(name="Reservations")
    public ReservationsCl getReservations() {
        return reservations;
    }

    public void setReservations(ReservationsCl reservations) {
        this.reservations = reservations;
    }
    private ReservationsCl reservations;
    
}
