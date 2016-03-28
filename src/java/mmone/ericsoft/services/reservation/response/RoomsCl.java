/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mmone.ericsoft.services.avail.request.RateCl;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Rooms",namespace = "http://response.reservation.services.ericsoft.mmone")
public class RoomsCl {
    private List<RoomCl> rooms;

    @XmlElement(name="Room")
    public List<RoomCl> getRooms() {
        if(rooms==null)
            rooms = new ArrayList<RoomCl>();
        return rooms;
    }

    public void setRooms(List<RoomCl> rooms) {
        this.rooms = rooms;
    }
}
