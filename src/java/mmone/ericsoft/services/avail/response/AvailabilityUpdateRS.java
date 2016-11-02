/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="AvailabilityUpdateResponse",namespace = "http://response.avail.response.services.ericsoft.mmone")
public class AvailabilityUpdateRS {
    private OkCl ok;

    @XmlElement(name="Ok")
    public OkCl getOk() { 
        return ok;
    }

    public void setOk(OkCl ok) {
        this.ok = ok;
    }
}
