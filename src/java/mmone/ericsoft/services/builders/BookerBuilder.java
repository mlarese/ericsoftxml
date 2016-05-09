/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import java.util.Map;
import mmone.ericsoft.services.reservation.response.BookerCl;

/**
 *
 * @author mauro.larese
 */
public class BookerBuilder {
    public static BookerCl build(Map reservation){
        BookerCl b = new BookerCl();
         
        try {  b.setAddress( (String) reservation.get("reservation_address")  );     } catch (Exception e) { }
        try {  b.setCap((String) reservation.get("reservation_zipcode")  );     } catch (Exception e) { }
        try {  b.setCity((String) reservation.get("reservation_city")  );     } catch (Exception e) { }
        try {  b.setCountryIsoCode((String) reservation.get("reservation_country")  );     } catch (Exception e) { }
        try {  b.setEmail((String) reservation.get("reservation_email")  );     } catch (Exception e) { }
        try {  b.setName((String) reservation.get("reservation_name")  );     } catch (Exception e) { }
        try {  b.setNotes((String) reservation.get("reservation_note")  );     } catch (Exception e) { }
        try {  b.setSurname((String) reservation.get("reservation_surname")  );     } catch (Exception e) { }
        try {  b.setTelephone((String) reservation.get("reservation_phone")  );     } catch (Exception e) { }
        //try {  b.setCreditCard(  CreditCardBuilder.build(reservation)     );} catch (Exception e) { }
         
        return b;
    }
}
