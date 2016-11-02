/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.request;

import com.mmone.abs.api.rates.Debuggable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="ReservationConfirmationRequest",namespace = "http://confirmation.reservation.request.services.ericsoft.mmone") 

public class ReservationConfirmationRQ{
    private String username; 
    private String password; 
    private String propertyCode;  
 
    
    @XmlElement(name="Username",required = true)  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 
    @XmlElement(name="Password",required = true)
    public String getPassword() {
        return password;
    }

    public void setReservations(ReservationsReqCl reservations) {
        this.reservations = reservations;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name="PropertyCode",required = true)
    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
  
    
    private ReservationsReqCl reservations;
    @XmlElement(name = "Reservations",namespace = "http://reservations.reservation.request.services.ericsoft.mmone")
    public ReservationsReqCl getReservations() {
        if (reservations== null) {
            reservations= new ReservationsReqCl();
        }
                 
        return reservations;
    }
 
     
}
