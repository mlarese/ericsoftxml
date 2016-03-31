/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name = "ReservationRetrievalResponse")
@XmlType(name="ReservationRetrievalResponse",namespace = "http://response.reservation.services.ericsoft.mmone")
public class ReservationRetrievalRS {
    @XmlElement(name = "Reservations")
    protected ReservationsCl reservations;

    public ReservationsCl getReservations() {
        if (reservations== null) {
            reservations= new ReservationsCl();
        }
        return reservations;
    }

    public void setReservations(ReservationsCl reservations) {
        this.reservations = reservations;
    }
  
     
}
