/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mmone.ericsoft.services.avail.request.RateCl;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Reservations",namespace = "http://response.reservation.services.ericsoft.mmone")
public class ReservationsCl {
    private List<ReservationCl> reservations;

    @XmlElement(name="Reservation")
    public List<ReservationCl> getReservations() {
        if(reservations==null)
            reservations = new ArrayList<ReservationCl>();
        return reservations;
    }

    public void setReservations(List<ReservationCl> reservations) {
        this.reservations = reservations;
    }
}
