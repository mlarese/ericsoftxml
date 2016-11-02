/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.request;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="ReservationRetrievalRequest",namespace = "http://retrieval.reservation.request.services.ericsoft.mmone") 
public class ReservationRetrievalRQ {
    private String username; 
    private String password; 
    private String propertyCode; 
    private String lastChange; 
    private String contextId=null; 

    @XmlElement(name = "LastChange")
    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }
    
    @XmlElement(name="Username")  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 
    @XmlElement(name="Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name="PropertyCode")
    public String getPropertyCode() {
        return propertyCode;
    } 

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
 
    @XmlElement(name="ContextId")
    public String getContextId() {
        return contextId;
    }
    
    public void setContextId(String contextId) {
        this.contextId = contextId;
    }
     
}
