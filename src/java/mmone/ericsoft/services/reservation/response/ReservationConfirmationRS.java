/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name = "ReservationConfirmationResponse")
@XmlType(name="ReservationConfirmationResponse",namespace = "http://confirmation.response.reservation.response.services.ericsoft.mmone")
public class ReservationConfirmationRS {
    @XmlElement(name = "Ok")
    protected Ok ok=new Ok();

    public Ok getOk() {
        return ok;
    }

    public void setOk(Ok ok) {
        this.ok = ok;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Ok{
        
    }
     
}
