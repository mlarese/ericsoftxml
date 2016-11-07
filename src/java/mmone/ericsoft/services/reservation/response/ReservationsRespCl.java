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
@XmlType(name="Reservations")
public class ReservationsRespCl {
    private List<ReservationRespCl> reservations;

    @XmlElement(name="Reservation")
    public List<ReservationRespCl> getReservations() {
        if(reservations==null)
            reservations = new ArrayList<ReservationRespCl>();
        return reservations;
    }

    public void setReservations(List<ReservationRespCl> reservations) {
        this.reservations = reservations;
    }
}
