/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.pax.Pax;
import com.mmone.abs.api.rates.BuildingResources;
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
        BuildingResources br,    
        Map reservation, 
        Map<String, Object> reservationDetailRoom  ,
        Map<String, Object> reservationDetailTotal  
    ){
        RoomCl r = new RoomCl();
        Pax pax = Pax.instance();
         
        r.setCheckIn( DateHelper.formatYMD(reservation.get("reservation_checkin_date"))      );
        r.setCheckOut(DateHelper.formatYMD(  reservation.get("reservation_checkout_date")     )      );
        r.setRoomReservationCode(reservationDetailRoom.get("reservation_detail_id").toString()   );
        r.setId(reservationDetailRoom.get("reservation_detail_room_id").toString()   );
        
        r.setRoomPrice(NumbersHelper.format2DigitUS((Float) reservationDetailRoom.get("reservation_detail_price")  )       );
        
        if(reservationDetailTotal!=null && reservationDetailTotal.get("reservation_detail_price")!=null){
            
            try{
                r.setRoomPrice(NumbersHelper.format2DigitUS((Float) reservationDetailTotal.get("reservation_detail_price")  )       );
            }catch(Exception e){
                r.setRoomPrice(NumbersHelper.format2DigitUS((Float) reservationDetailRoom.get("reservation_detail_price")  )       );
            }
            
        } 
        
         
        r.setPrices(PricesBuilder.build(br,reservation,reservationDetailRoom,reservationDetailTotal)  );
        
        try { 
            pax.elaboratePax(reservationDetailRoom.get("reservation_detail_room_guest").toString());
            r.setAdultsNumber(pax.getAdults());
            r.setChildrenNumber(pax.getChildren());
        } catch (Exception e) { 
            Logger.getLogger("RoomsBuilder").log(Level.SEVERE,reservationDetailRoom.get("reservation_detail_room_guest").toString(),e);
        }
        return r;
    }
    public static RoomsCl build(
        BuildingResources br,      
        Map reservation, 
        List<Map<String, Object>> reservationDetailRooms,  
        List<Map<String, Object>> reservationDetailTotals  
    ){
        RoomsCl rs = new RoomsCl();
        
        for (int i = 0; i < reservationDetailRooms.size(); i++) {
            
            Map<String, Object> resDetailRoom = reservationDetailRooms.get(i);
            Map<String, Object> resDetailTotal=null;
            if(reservationDetailTotals.size()== reservationDetailRooms.size()){
                resDetailTotal=reservationDetailTotals.get(i);
            }
            rs.getRooms().add(   buildRoom(br,reservation,resDetailRoom,resDetailTotal)   );
        }

          
        return rs;
    }
}
