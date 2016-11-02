/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mauro.larese
 */
@XmlRootElement(name="AvailabilityUpdateRequest") 
@XmlType(name="AvailabilityUpdate_Request",namespace = "http://request.avail.request.services.ericsoft.mmone") 
public class AvailabilityUpdateRQ {  
    
   
    private String username; 
    private String password; 
    private String propertyCode;

    @XmlElement(name="RoomTypes")  
    public RoomTypesReqCl getRoomTypes() {
        if (roomTypes== null) {
            roomTypes= new RoomTypesReqCl();
        }
        return roomTypes;
    }

    public void setRoomTypes(RoomTypesReqCl roomTypes) {
        this.roomTypes = roomTypes;
    }
    private RoomTypesReqCl roomTypes;
    
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
    
}
