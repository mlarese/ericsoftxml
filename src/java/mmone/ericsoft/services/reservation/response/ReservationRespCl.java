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
@XmlType(name="Reservation")
public class ReservationRespCl {
    private String id;
    private String totalPrice;
    private String creationDate;
    private String lastChangeDate;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "TotalPrice")
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement(name="CreationDate")
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @XmlElement(name="LastChangeDate")
    public String getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(String lastChangeDate) {
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
    
    @XmlElement(name="Rooms")
    public RoomsCl getRooms() {
        return rooms;
    }

    public void setRooms(RoomsCl rooms) {
        this.rooms = rooms;
    }
    private RoomsCl rooms;
    
}
