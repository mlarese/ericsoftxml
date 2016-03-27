/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.rooms.response;
 
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author mauro.larese
 */
@XmlType(name="RoomType")
public class RoomTypeCl {

    public RoomTypeCl() {
    }

    public RoomTypeCl(String id, String Description, List<RateCl> rates) {
        this.id = id;
        this.description = Description;
        this.rates = rates;
    }
    
    private String id;

    @XmlAttribute(name="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomTypeCl(String id, String description) {
        this.id = id;
        this.description = description;
    }
    
    @XmlElement(name="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    @XmlElement(name="Rates")
    public List<RateCl> getRates() {
        if(rates==null)
            rates = new ArrayList<RateCl>();
        return rates;
    }

    public void setRates(List<RateCl> rates) {
        this.rates = rates;
    }
    
    private String description;
    
    private List<RateCl> rates;
    
}
