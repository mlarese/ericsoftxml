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
@XmlRootElement(name = "ReservationRetrievalResponse",namespace = "http://response.reservation.response.services.ericsoft.mmone")
@XmlType(name="ReservationRetrievalResponse",namespace = "http://response.reservation.response.services.ericsoft.mmone")
public class ReservationRetrievalRS {
    @XmlElement(name = "Reservations")
    protected ReservationsRespCl reservations;

    public ReservationsRespCl getReservations() {
        if (reservations== null) {
            reservations= new ReservationsRespCl();
        }
        return reservations;
    }

    public void setReservations(ReservationsRespCl reservations) {
        this.reservations = reservations;
    }
  
     
}
