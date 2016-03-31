/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.helpers.dates.DateHelper;
import com.mmone.abs.helpers.numbers.NumbersHelper;
import java.util.Date;
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
    public static PricesCl build(Map reservation,Map<String, Object> reservationDetail){
        PricesCl obj = new PricesCl();
         
        try {
            Date chkin=(Date)reservation.get("reservation_checkin_date");
            Date chkout = (Date) reservation.get("reservation_checkout_date");
            float totalPrice=(Float)reservationDetail.get("reservation_detail_price");
            long period = DateHelper.dateDiff(chkin, chkout)-1;
            long days= period+1;
            float cprice =  totalPrice/days;
            String price = NumbersHelper.format2DigitUS(  cprice );
            
            for (int i = 0; i <= period; i++) {
                 
                java.util.Date curDate = DateUtils.addDays(chkin, i);
                String sCurDate = DateHelper.formatYMD(curDate);
                PriceCl p = new PriceCl();
                p.setDate(sCurDate);
                p.setIdRate( (Integer)reservationDetail.get("reservation_detail_list_id")  );
                p.setPrice(price);
                
                obj.getPrices().add(p);
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(PricesBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    }
}
 