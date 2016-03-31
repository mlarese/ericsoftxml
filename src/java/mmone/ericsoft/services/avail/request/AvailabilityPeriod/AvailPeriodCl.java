/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request.AvailabilityPeriod;
 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese 
 */

@XmlType(name="Period",namespace = "http://availperiod.request.avail.services.ericsoft.mmone")
public class AvailPeriodCl{
    private String start;
    private String end;
    private int availability;

    @XmlElement(name="Availability")
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }


    @XmlAttribute(name="start")
    public String getStart() {
        return start;
    }


    public void setStart(String start) {
        this.start = start;
    }


    @XmlAttribute(name="end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

