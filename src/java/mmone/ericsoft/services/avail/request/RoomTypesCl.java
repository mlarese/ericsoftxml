/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="RoomTypes",namespace = "http://request.avail.services.ericsoft.mmone")
public class RoomTypesCl {
    private List<RoomTypeCl> roomTypes;

    @XmlElement(name="RoomType")
    public List<RoomTypeCl> getRoomTypesList() {
        if(roomTypes==null)
            roomTypes=new ArrayList<RoomTypeCl>();
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeCl> roomTypes) {
        this.roomTypes = roomTypes;
    }   
}
