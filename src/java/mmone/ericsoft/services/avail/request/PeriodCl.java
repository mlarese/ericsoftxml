/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;
 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
*/
@XmlType(name="Period",namespace = "http://request.avail.request.services.ericsoft.mmone")
public class PeriodCl {
    private String start;
    private String end;
    private boolean closed;
    private float price;
    private int maxStay;
    private int minStay;
    private boolean closedArrival;
    private boolean closedDeparture;
    
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

    @XmlElement(name="Closed")
    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @XmlElement(name="Price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlElement(name="MaxStay")
    public int getMaxStay() {
        return maxStay;
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }

    @XmlElement(name="MinStay")
    public int getMinStay() {
        return minStay;
    }

    public void setMinStay(int minStay) {
        this.minStay = minStay;
    }

    @XmlElement(name="ClosedArrival")
    public boolean isClosedArrival() {
        return closedArrival;
    }

    public void setClosedArrival(boolean closedArrival) {
        this.closedArrival = closedArrival;
    }
    @XmlElement(name="ClosedDeparture")
    public boolean isClosedDeparture() {
        return closedDeparture;
    }

    public void setClosedDeparture(boolean closedDeparture) {
        this.closedDeparture = closedDeparture;
    }
    
}
