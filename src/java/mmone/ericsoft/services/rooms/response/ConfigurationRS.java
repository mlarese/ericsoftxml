package mmone.ericsoft.services.rooms.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mauro.larese
 */ 

@XmlType(name = "ConfigurationResponse",namespace = "http://response.rooms.response.services.ericsoft.mmone") 
@XmlRootElement(name = "ConfigurationResponse") 
public class ConfigurationRS {
    private RoomTypesRespCl roomTypes;

    @XmlElement(name = "RoomTypes")
    public RoomTypesRespCl getRoomTypes() {
        if(roomTypes==null)
            roomTypes=new RoomTypesRespCl();
        return roomTypes;
    }

    public void setRoomTypes(RoomTypesRespCl roomTypes) {
        this.roomTypes = roomTypes;
    }
    
    
    
}
