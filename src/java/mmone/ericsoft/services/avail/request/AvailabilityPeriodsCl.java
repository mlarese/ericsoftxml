/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mmone.ericsoft.services.avail.request.AvailabilityPeriod.AvailPeriodCl;

/** 
 *
 * @author maurolarese
 */
@XmlType(name="AvailabilityPeriod",namespace = "http://request.avail.services.ericsoft.mmone")
public class AvailabilityPeriodsCl {
    private List<AvailabilityPeriodCl> availabilityPeriod;
    @XmlElement(name="Period")
    public List<AvailabilityPeriodCl> getPeriodList() {
        if(availabilityPeriod==null)
            availabilityPeriod = new ArrayList<AvailabilityPeriodCl>();
        return availabilityPeriod;
    }

    public void setPeriodList(List<AvailabilityPeriodCl> periods) {
        this.availabilityPeriod = availabilityPeriod;
    }
    
    
    /**
    
    @XmlElement(name="Period")
    public AvailPeriodCl getPeriod() {
        return period;
    }

    public void setPeriod(AvailPeriodCl period) {
        this.period = period;
    }
    private AvailPeriodCl period;
    * */
}
