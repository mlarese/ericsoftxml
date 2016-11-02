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
@XmlType(name="RoomType",namespace = "http://request.avail.request.services.ericsoft.mmone")
public class RoomTypeReqCl {

    private RatesCl rates;
    private AvailabilityPeriodsCl availabilityPeriod;

    @XmlElement(name="AvailabilityPeriod")
    public AvailabilityPeriodsCl getAvailabilityPeriod() {
        return availabilityPeriod;
    }

    public void setAvailabilityPeriod(AvailabilityPeriodsCl availabilityPeriod) {
        this.availabilityPeriod = availabilityPeriod;
    }

    @XmlElement(name = "Rates")
    public RatesCl getRates() { 
        return rates;
    }

    public void setRates(RatesCl rates) {
        this.rates = rates;
    }
    
    public RoomTypeReqCl() {
    }

 
    
    private String id;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

     
    
}
