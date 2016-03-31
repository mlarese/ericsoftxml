/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.pax.Pax;
import com.mmone.abs.helpers.dates.DateHelper;
import com.mmone.abs.helpers.numbers.NumbersHelper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mmone.ericsoft.services.reservation.response.BookerCl;
import mmone.ericsoft.services.reservation.response.RoomCl;
import mmone.ericsoft.services.reservation.response.RoomsCl;
import org.apache.commons.lang.time.DateUtils;
 
public class RoomsBuilder {
    public static RoomCl buildRoom(
        Map reservation, 
        Map<String, Object> reservationDetail  
    ){
        RoomCl r = new RoomCl();
        Pax pax = Pax.instance();
         
        r.setCheckIn( DateHelper.formatYMD(reservation.get("reservation_checkin_date"))      );
        r.setCheckOut(DateHelper.formatYMD(  reservation.get("reservation_checkout_date")     )      );
        r.setRoomReservationCode(   reservationDetail.get("reservation_detail_id").toString()   );
        r.setId(reservationDetail.get("reservation_detail_room_id").toString()   );
        r.setRoomPrice(  NumbersHelper.format2DigitUS( (Float) reservationDetail.get("reservation_detail_price")  )       );
        r.setPrices(   PricesBuilder.build(reservation,reservationDetail)  );
        try { 
            pax.elaboratePax(reservationDetail.get("reservation_detail_room_guest").toString());
            r.setAdultsNumber(pax.getAdults());
            r.setChildrenNumber(pax.getChildren());
        } catch (Exception e) { 
            Logger.getLogger("RoomsBuilder").log(Level.SEVERE,reservationDetail.get("reservation_detail_room_guest").toString(),e);
        }
        return r;
    }
    public static RoomsCl build(
        Map reservation, 
        List<Map<String, Object>> reservationDetail 
    ){
        RoomsCl rs = new RoomsCl();
        
        for (Map<String, Object> resDetail : reservationDetail) {
            rs.getRooms().add(  buildRoom(reservation,resDetail)  );
        }
          
        return rs;
    }
}
