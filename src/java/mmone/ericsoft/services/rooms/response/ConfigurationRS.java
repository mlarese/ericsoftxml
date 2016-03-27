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

@XmlRootElement(name = "ConfigurationResponse")
public class ConfigurationRS {
    
    private List<RoomTypeCl> roomTypes;

    @XmlElement(name="RoomTypes")
    public List<RoomTypeCl> getRoomTypes() {
        if(roomTypes==null)
            roomTypes=new ArrayList<RoomTypeCl>();
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeCl> roomTypes) {
        this.roomTypes = roomTypes;
    }
}
