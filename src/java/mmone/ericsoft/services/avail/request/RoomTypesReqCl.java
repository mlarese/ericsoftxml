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
@XmlType(name="RoomTypes",namespace = "http://request.avail.request.services.ericsoft.mmone")
public class RoomTypesReqCl {
    private List<RoomTypeReqCl> roomTypes;

    @XmlElement(name="RoomType")
    public List<RoomTypeReqCl> getRoomTypesList() {
        if(roomTypes==null)
            roomTypes=new ArrayList<RoomTypeReqCl>();
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeReqCl> roomTypes) {
        this.roomTypes = roomTypes;
    }   
}
