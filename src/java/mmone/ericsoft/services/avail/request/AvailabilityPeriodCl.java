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
@XmlType(name="AvaPeriod",namespace = "http://request.avail.services.ericsoft.mmone")
public class AvailabilityPeriodCl { 
    private String start;
    private String end;
    
    @XmlElement(name="Availability")
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    private int availability;
  
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
