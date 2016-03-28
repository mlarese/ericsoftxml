/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request.AvailabilityPeriod;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese 
 */

@XmlType(name="Period",namespace = "http://availperiod.request.avail.services.ericsoft.mmone")
public class AvailPeriodCl{
    private Date start;
    private Date end;
    private int availability;

    @XmlElement(name="Availability")
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }


    @XmlAttribute(name="start")
    public Date getStart() {
        return start;
    }


    public void setStart(Date start) {
        this.start = start;
    }


    @XmlAttribute(name="end")
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

