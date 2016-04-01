/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.Authenticator;
import com.mmone.abs.api.avail.AvailCrud;
import com.mmone.abs.api.rates.AbsBookingRule;
import com.mmone.abs.api.rates.RatePlanCrud;
import com.mmone.abs.api.room.RoomCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.avail.request.AvailabilityPeriod.AvailPeriodCl;
import mmone.ericsoft.services.avail.request.AvailabilityPeriodCl;
import mmone.ericsoft.services.avail.request.AvailabilityUpdateRQ;
import mmone.ericsoft.services.avail.request.PeriodCl;
import mmone.ericsoft.services.avail.request.RateCl;
import mmone.ericsoft.services.avail.request.RoomTypeCl;
import mmone.ericsoft.services.avail.request.RoomTypesCl;
import mmone.ericsoft.services.avail.response.AvailabilityUpdateRS;
import mmone.ericsoft.services.avail.response.OkCl;
import mmone.ericsoft.services.helper.AuthHelper; 

/**
 *
 * @author mauro.larese
 */
public class AvailabilityResponseBuilder extends AbstractResponseBuilder<AvailabilityUpdateRQ,AvailabilityUpdateRS> {
    private AvailabilityUpdateRS response ;
    private AvailabilityUpdateRQ request ;

    public AvailabilityResponseBuilder(AvailabilityUpdateRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
        //setMock(true);
    }
  
    @Override
    public String getHotelCodeFromRequest() {
        return getRequest().getPropertyCode();
    }
    
    private void setRestrictions(RoomTypeCl room){
        if(
            room.getRates()!=null
        ){
            List<RateCl>rlst =  room.getRates().getRateList();
            for (RateCl r : rlst) {
                PeriodCl p = r.getPeriod();
                String dts = p.getStart(); 
                String dte = p.getEnd();
                Integer listId = new Integer(r.getId());
                
                AbsBookingRule absbr = new AbsBookingRule();
                
                absbr.setMaxStay(  p.getMaxStay() )      ;
                absbr.setMinStay(p.getMinStay())      ;
                absbr.setClosed(p.isClosed()?1:0)      ;
                absbr.setStartDate(dts)      ;
                absbr.setEndDate(dte)      ;
                
                boolean[] arrivalDow = new boolean[7];
                boolean[] departureDow = new boolean[7];
                for (int i = 0; i < 7; i++) {
                    arrivalDow[i]=!p.isClosedArrival();
                    departureDow[i]=!p.isClosedDeparture();
                }
                absbr.setDow(arrivalDow, departureDow);
                
                try {
                    RatePlanCrud.setRestrictions(
                            getRunner(),
                            getElaborationResults(),
                            listId,
                            getHotelId(),
                            new Integer(room.getId()), 
                            absbr);
                    
                } catch (Exception ex) {
                    getErrors().add(new ErrType("Error setting availability"));
                    Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    private void saveAllotment(RoomTypeCl rt){
        if(
            rt.getAvailabilityPeriod()!=null && 
            rt.getAvailabilityPeriod().getPeriod()!=null 
        ){
            int ava = rt.getAvailabilityPeriod().getPeriod().getAvailability();
            String dts = rt.getAvailabilityPeriod().getPeriod().getStart();
            String dte = rt.getAvailabilityPeriod().getPeriod().getEnd();
            try {
                AvailCrud.saveAllotment(getRpcClient(), getHotelId(), dts, dte, new Integer(rt.getId()), ava);
            } catch (Exception ex) {
               getErrors().add(  new ErrType("Error inserting data")  );
               Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    @Override
    public void buildResponse() {
        List<RoomTypeCl> rts = getRequest().getRoomTypes().getRoomTypesList();
         
        for (RoomTypeCl rt : rts) { 
            saveAllotment(rt);
            setRestrictions(rt);
        }
        
    }

    @Override
    public void fillErrors() {
        response=new AvailabilityUpdateRS();
         
    }

    @Override
    public void fillWarnings() {
         
    }

    @Override
    public void markSuccess() {
        getResponse().setOk(new OkCl());
    }

    @Override
    protected void authentication() throws UserNotAuthorized {
        if(true) return;
        this.setAuth(AuthHelper.doAuth(
            this.getRequest().getUsername(), 
            this.getRequest().getPassword(),  
            this.getHotelId(),
            this.getRunner())
        );
    }
 
    public AvailabilityUpdateRS getResponse() {
        if(response==null)
            response=new AvailabilityUpdateRS();
        return response;
    }
    
  
    
}
