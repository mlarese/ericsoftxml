/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.rates.BuildingResources;
import com.mmone.abs.api.rates.Debuggable;
import com.mmone.abs.api.reservation.ResStatusConst;
import com.mmone.abs.helpers.dates.DateHelper;
import com.mmone.abs.helpers.numbers.NumbersHelper;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mmone.ericsoft.services.reservation.response.BookerCl;
import mmone.ericsoft.services.reservation.response.ReservationRespCl;
import org.apache.commons.lang.math.NumberUtils;

/**
 *
 * @author mauro.larese
 */
public class ReservationBuilder {
    public static final String RES_STATUS_NEW ="new";
    public static final String RES_STATUS_MOD ="modified";
    public static final String RES_STATUS_CANC ="canceled";
    
   
    public static String getConvertStatus(int absStatus){
        int gStatus = ResStatusConst.groupStatus(absStatus);
        
        switch(gStatus){
            case ResStatusConst.RESERVATION_STATUS_GROUP_CONF : return RES_STATUS_NEW;
            case ResStatusConst.RESERVATION_STATUS_GROUP_MODI : return RES_STATUS_MOD;
            case ResStatusConst.RESERVATION_STATUS_GROUP_CANC : return RES_STATUS_CANC;
            default : return RES_STATUS_NEW;
        }
    }
    
    public static ReservationRespCl build(
        BuildingResources br,      
        Map reservation, 
        List<Map<String, Object>> reservationDetailRooms,  
        List<Map<String, Object>> reservationDetailTotals
    ) {
             
        ReservationRespCl r = new ReservationRespCl();
        r.setBooker( BookerBuilder.build(reservation)  ); 
         
        try { r.setCreationDate( DateHelper.formatISO8601(reservation.get("reservation_opened_date"))  );  } catch (Exception e) {  }
        try { r.setLastChangeDate(DateHelper.formatISO8601(reservation.get("reservation_status_date"))  );  } catch (Exception e) {  }
        try { r.setId( reservation.get("reservation_id").toString()  );  } catch (Exception e) {  }
        try { r.setState(    getConvertStatus((Integer)reservation.get("reservation_status"))  );  } catch (Exception e) {  }
        try { r.setTotalPrice(   NumbersHelper.format2DigitUS((Float)reservation.get("reservation_tot_reservation_price") ));  } catch (Exception e) {  }
        
        r.setRooms(RoomsBuilder.build(br, reservation, reservationDetailRooms,reservationDetailTotals) );
        
        return r;
    }
}
