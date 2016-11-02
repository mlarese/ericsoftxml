/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.rooms.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mauro.larese
 */
@XmlRootElement(name="ConfigurationRequest")  
@XmlType(name="Configuration_Request",namespace = "http://configuration.reservation.request.services.ericsoft.mmone") 
public class ConfigurationRQ { 
    private String username; 
    private String password; 
    private String propertyCode;
    
    @XmlElement(name="Username",required = true)  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 
    @XmlElement(name="Password",required = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name="PropertyCode",required = true)
    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
    
}
