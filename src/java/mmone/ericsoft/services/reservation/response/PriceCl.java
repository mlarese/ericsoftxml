/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Price",namespace = "http://response.reservation.services.ericsoft.mmone")
public class PriceCl {
    private int idRate;
    private Date date;

    @XmlAttribute(name = "idRate")
    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }
    @XmlAttribute(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlValue
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    private float price;
   
    
}
