/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.rates.AbsTreatment;
import com.mmone.abs.api.rates.BuildingResources;
import com.mmone.abs.helpers.dates.DateHelper;
import com.mmone.abs.helpers.numbers.NumbersHelper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mmone.ericsoft.services.reservation.response.BookerCl;
import mmone.ericsoft.services.reservation.response.CreditCardCl;
import mmone.ericsoft.services.reservation.response.PriceCl;
import mmone.ericsoft.services.reservation.response.PricesCl;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author mauro.larese
 */
public class PricesBuilder {
    public static PricesCl build(BuildingResources br, Map reservation,Map<String, Object> reservationDetailRoom,Map<String, Object> reservationDetailTotal){
        PricesCl obj = new PricesCl();
        Map<String, AbsTreatment>treatments= br.getTreatmentsBykey();
         
        try {
            String board = (String)reservationDetailRoom.get("reservation_detail_room_board"); 
            AbsTreatment tr;
            
            if(board==null){
                tr = new AbsTreatment();
                tr.setTreatment_id(1);
                tr.setTreatment_code("OB");
                tr.setTreatment_name("Only Board");
            }else    
                tr= treatments.get(  board   );
             
            Date chkin=(Date)reservation.get("reservation_checkin_date");
            Date chkout = (Date) reservation.get("reservation_checkout_date");
            double totalPrice=(Double)reservationDetailRoom.get("reservation_detail_price"); 
            
            if(reservationDetailTotal!=null && reservationDetailTotal.get("reservation_detail_price")!=null){ 
                try{
                    totalPrice=(Double)reservationDetailTotal.get("reservation_detail_price");
                }catch(Exception e){
                    totalPrice=(Double)reservationDetailRoom.get("reservation_detail_price");
                }

            } 
            
            long period = DateHelper.dateDiff(chkin, chkout)-1;
            long days= period+1;
            double cprice =  totalPrice/days;
            String price = NumbersHelper.format2DigitUS(  cprice );
            
            
            Integer curLid = (Integer) reservationDetailRoom.get("reservation_detail_list_id");
            if(curLid==null) {
                curLid=1;
            }
            
            Integer trId = 0;
            
            if(tr!=null) {
                trId = tr.getTreatment_id();
            }
            
            String listId = curLid.toString()
                            +"-"
                            +trId;
            
            for (int i = 0; i <= period; i++) {
                 
                java.util.Date curDate = DateUtils.addDays(chkin, i);
                String sCurDate = DateHelper.formatYMD(curDate);
                PriceCl p = new PriceCl();
                p.setDate(sCurDate);
                p.setIdRate( listId  );
                p.setPrice(price);
                
                obj.getPrices().add(p);
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PricesBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    }
}
 