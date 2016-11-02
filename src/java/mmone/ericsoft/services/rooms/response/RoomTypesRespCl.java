/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.rooms.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="RoomTypes",namespace = "http://response.rooms.response.services.ericsoft.mmone")
public class RoomTypesRespCl {
    private List<RoomTypeRespCl> roomTypes;

    @XmlElement(name="RoomType")
    public List<RoomTypeRespCl> getRoomTypesList() {
        if(roomTypes==null)
            roomTypes=new ArrayList<RoomTypeRespCl>();
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeRespCl> roomTypes) {
        this.roomTypes = roomTypes;
    }   

    
        
  }
