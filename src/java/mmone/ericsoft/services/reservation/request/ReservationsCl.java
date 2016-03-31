/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.request;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Reservations",namespace = "http://request.reservation.services.ericsoft.mmone")
public class ReservationsCl {
    private ReservationCl reservation;

    public void setReservation(ReservationCl reservation) {
        this.reservation = reservation;
    }

    @XmlElement(name="Reservation")
    public ReservationCl getReservation() { ;
        return reservation;
    }
 
} 
