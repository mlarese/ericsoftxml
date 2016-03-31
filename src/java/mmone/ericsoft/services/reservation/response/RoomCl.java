/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import com.mmone.abs.helpers.dates.DateHelper;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Room",namespace = "http://response.reservation.services.ericsoft.mmone")
public class RoomCl {
    private String id; 

    @XmlAttribute(name="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String roomReservationCode;
    private String notes;
    private String checkIn;

    @XmlElement(name="RoomReservationCode")
    public String getRoomReservationCode() {
        return roomReservationCode;
    }

    public void setRoomReservationCode(String roomReservationCode) {
        this.roomReservationCode = roomReservationCode;
    }
    @XmlElement(name="Notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    @XmlElement(name="CheckIn")
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    @XmlElement(name="CheckOut")
    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
      
    @XmlElement(name="AdultsNumber")
    public int getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }
    @XmlElement(name="ChildrenNumber")
    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }
    @XmlElement(name="RoomPrice") 
    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }
    private String checkOut;
    private int adultsNumber;
    private int childrenNumber;
    private String roomPrice;

    @XmlElement(name="Prices")
    public PricesCl getPrices() {
        return prices;
    }

    public void setPrices(PricesCl prices) {
        this.prices = prices;
    }
    private PricesCl prices;
}
