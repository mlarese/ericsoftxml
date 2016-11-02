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

/**
 *
 * @author maurolarese
 */
@XmlType(name="CreditCard",namespace = "http://response.reservation.response.services.ericsoft.mmone")
public class CreditCardCl {
    private String type;
    private String number;

    @XmlElement(name="Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlElement(name="Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @XmlElement(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="SecurityCode")
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
    @XmlElement(name="Expiration")
    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    private String name;
    private String securityCode;
    private String expiration;

    
    
}
