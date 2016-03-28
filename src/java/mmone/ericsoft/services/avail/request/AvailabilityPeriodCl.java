/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mmone.ericsoft.services.avail.request.AvailabilityPeriod.AvailPeriodCl;

/** 
 *
 * @author maurolarese
 */
@XmlType(name="AvailabilityPeriod",namespace = "http://request.avail.services.ericsoft.mmone")
public class AvailabilityPeriodCl {
    
    @XmlElement(name="Period")
    public AvailPeriodCl getPeriod() {
        return period;
    }

    public void setPeriod(AvailPeriodCl period) {
        this.period = period;
    }
    private AvailPeriodCl period;
}
