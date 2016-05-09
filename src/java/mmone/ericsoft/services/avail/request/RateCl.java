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
 * @author mauro.larese
 */
@XmlType(name="Rate",namespace = "http://request.avail.services.ericsoft.mmone")
public class RateCl { 
    private String id;    
    private PeriodCl period;

    @XmlElement(name="Period")
    public PeriodCl getPeriod() {
        return period;
    }

    public void setPeriod(PeriodCl period) {
        this.period = period;
    }

    public RateCl(String id, PeriodCl period) {
        this.id = id;
        this.period = period;
    }
    
    public RateCl() {
    }
    
    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    
}
