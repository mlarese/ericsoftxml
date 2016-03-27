package mmone.ericsoft.services.rooms.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mauro.larese
 */ 

@XmlType(name = "ConfigurationResponse") 
@XmlRootElement(name = "ConfigurationResponse") 
public class ConfigurationRS {
    private RoomTypesCl roomTypes;

    @XmlElement(name = "RoomTypes")
    public RoomTypesCl getRoomTypes() {
        if(roomTypes==null)
            roomTypes=new RoomTypesCl();
        return roomTypes;
    }

    public void setRoomTypes(RoomTypesCl roomTypes) {
        this.roomTypes = roomTypes;
    }
}
