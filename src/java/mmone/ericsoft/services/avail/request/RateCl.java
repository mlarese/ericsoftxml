/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import java.util.ArrayList;
import java.util.List;
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
    private List<PeriodCl> periodList;
    @XmlElement(name="Period")
    public List<PeriodCl> getPeriodList() {
        if(periodList==null)
            periodList = new ArrayList<PeriodCl>();
        return periodList;
    }

    public void setPeriodList(List<PeriodCl> periods) {
        this.periodList = periods;
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
