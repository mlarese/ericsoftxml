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
    private String nntes;
    private Date checkIn;

    @XmlElement(name="RoomReservationCode")
    public String getRoomReservationCode() {
        return roomReservationCode;
    }

    public void setRoomReservationCode(String roomReservationCode) {
        this.roomReservationCode = roomReservationCode;
    }
    @XmlElement(name="Nntes")
    public String getNntes() {
        return nntes;
    }

    public void setNntes(String nntes) {
        this.nntes = nntes;
    }
    @XmlElement(name="CheckIn")
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
    @XmlElement(name="CheckOut")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
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
    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }
    private Date checkOut;
    private int adultsNumber;
    private int childrenNumber;
    private float roomPrice;

    @XmlElement(name="Prices")
    public PricesCl getPrices() {
        return prices;
    }

    public void setPrices(PricesCl prices) {
        this.prices = prices;
    }
    private PricesCl prices;
}
