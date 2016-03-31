/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import java.util.Map;
import mmone.ericsoft.services.reservation.response.BookerCl;
import mmone.ericsoft.services.reservation.response.CreditCardCl;

/**
 *
 * @author mauro.larese
 */
public class CreditCardBuilder {
    public static CreditCardCl build(Map reservation){
        CreditCardCl obj = new CreditCardCl();
         
        try {  obj.setExpiration((String) reservation.get("reservation_cc_exp_date")  );     } catch (Exception e) { }
        try {  obj.setName((String) reservation.get("reservation_cc_holder")  );     } catch (Exception e) { }
        try {  obj.setNumber((String) reservation.get("reservation_cc_number")  );     } catch (Exception e) { }
        try {  obj.setSecurityCode((String) reservation.get("reservation_cc_sec_code")  );     } catch (Exception e) { }
        try {  obj.setType((String) reservation.get("reservation_cc_type")  );     } catch (Exception e) { }
        
        return obj;
    }
}
