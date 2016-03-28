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
@XmlType(name="RoomType",namespace = "http://request.avail.services.ericsoft.mmone")
public class RoomTypeCl {

    private RatesCl rates;
    private AvailabilityPeriodCl availabilityPeriod;

    @XmlElement(name="AvailabilityPeriod")
    public AvailabilityPeriodCl getAvailabilityPeriod() {
        return availabilityPeriod;
    }

    public void setAvailabilityPeriod(AvailabilityPeriodCl availabilityPeriod) {
        this.availabilityPeriod = availabilityPeriod;
    }

    @XmlElement(name = "Rates")
    public RatesCl getRates() {
        if(rates==null)
            rates=new RatesCl();
        return rates;
    }

    public void setRates(RatesCl rates) {
        this.rates = rates;
    }
    
    public RoomTypeCl() {
    }

 
    
    private String id;

    @XmlAttribute(name="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

     
    
}
