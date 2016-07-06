/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.AuthHelper;
import com.mmone.abs.api.avail.AvailCrud;
import com.mmone.abs.api.rates.AbsBaseGuestAmount;
import com.mmone.abs.api.rates.AbsBaseGuestAmountByPerson;
import com.mmone.abs.api.rates.AbsBaseGuestAmountByRoom;
import com.mmone.abs.api.rates.AbsBookingRule;
import com.mmone.abs.api.rates.AbsContextRecord;
import com.mmone.abs.api.rates.AbsRate;
import com.mmone.abs.api.rates.BuildingResources;
import com.mmone.abs.api.rates.RatePlanCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.Consts;
import com.mmone.abs.helpers.DayRules;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized; 
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.avail.request.AvailabilityPeriodCl;
import mmone.ericsoft.services.avail.request.AvailabilityUpdateRQ;
import mmone.ericsoft.services.avail.request.PeriodCl;
import mmone.ericsoft.services.avail.request.PeriodsCl;
import mmone.ericsoft.services.avail.request.RateCl;
import mmone.ericsoft.services.avail.request.RoomTypeCl;
import mmone.ericsoft.services.avail.response.AvailabilityUpdateRS;
import mmone.ericsoft.services.avail.response.OkCl; 
import mmone.ericsoft.services.helper.Constants;

/**
 *
 * @author mauro.larese
 */
public class AvailabilityResponseBuilder extends AbstractResponseBuilder<AvailabilityUpdateRQ,AvailabilityUpdateRS> {
    private AvailabilityUpdateRS response ;
    private AvailabilityUpdateRQ request ;
    private boolean noPrices = true;
    
    public AvailabilityResponseBuilder(AvailabilityUpdateRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
        //setMock(true);
    }
  
    @Override
    public String getHotelCodeFromRequest() {
        return getRequest().getPropertyCode();
    }
   
    private void setPriceAndRestrictions(RoomTypeCl room) throws Exception{
        if(
            room.getRates()!=null
        ){
            AbsContextRecord absContextRecord = new AbsContextRecord();
            BuildingResources br = getBuildingResources();
             
            DayRules dr=new DayRules();
            List<RateCl>rlst =  room.getRates().getRateList();
            for (RateCl r : rlst) { 
                List<PeriodCl> prds = r.getPeriodList(); 
                Map<String,AbsRate> pricelist  = new Hashtable();
                String treatmentId=null;
                String listId=   r.getId() ;
                String[]aLisId= listId.split("-");
                listId=aLisId[0];
                treatmentId = "1" ;

                if(aLisId.length>1)
                    treatmentId=aLisId[1];  
                
                for (PeriodCl p : prds) { 
                    String dts = p.getStart(); 
                    String dte = p.getEnd();
                    float price=p.getPrice();
                     
                    try { 
                        AbsRate rate;    
                        String rateKey = room.getId()+"-"+listId+"-"+dts+"-"+dte;

                        if(!pricelist.containsKey(rateKey)){ 
                            rate=new AbsRate();

                            rate
                                .setRateId(listId)
                                .setStartDate(dts)
                                .setEndDate(dte) 
                                .setRoomId(room.getId())  ; 
                            pricelist.put(rateKey, rate);
                        }else{
                            rate=pricelist.get(rateKey);
                        } 

                        AbsBaseGuestAmount ga = new AbsBaseGuestAmountByRoom();
                                    ga.setAmount(price); 
                                    ga.setTreatment( new Integer(treatmentId)); 
                                    ga.setAgeQualifyingCode(Consts.ADULT_QUALYFING_CODE);

                        rate.addGuestAmount(ga)  ; 
                    } catch (Exception ex) {
                        getErrors().add(new ErrType("Error setting price"));
                        Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
                    }


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
                                new Integer(listId),
                                getHotelId(),
                                new Integer(room.getId()), 
                                absbr);

                    } catch (Exception ex) {
                        getErrors().add(new ErrType("Error setting restrictions"));
                        Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                
                if(!noPrices){
                    for (Map.Entry<String, AbsRate> curRate : pricelist.entrySet()) {  
                        RatePlanCrud.insertPricelists( br,  absContextRecord,  dr,  curRate.getValue() )  ;
                    }
                }     
            }
             
            
            
             
        }
    }
    private void saveAllotment(RoomTypeCl rt){
        if(
            rt.getAvailabilityPeriod()!=null  
        ){
            List<AvailabilityPeriodCl>periods = rt.getAvailabilityPeriod().getPeriodList();
            
            for (AvailabilityPeriodCl period : periods) {
                int ava = period.getAvailability();
                String dts = period.getStart();
                String dte = period.getEnd();
                try {
                    Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.INFO,  
                        "saving Avail - " 
                        +" hcode " +getHotelId()    
                        +" rt.getId() " +rt.getId()     
                    );
                    AvailCrud.saveAllotment(getRpcClient(), getHotelId(), dts, dte, new Integer( rt.getId() ), ava);
                } catch (Exception ex) { 
                   getErrors().add(  new ErrType("Error inserting data")  );
                   Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.INFO, rt.getId() );
                   Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
            
        }
    }
    @Override
    public void buildResponse() {
        List<RoomTypeCl> rts = getRequest().getRoomTypes().getRoomTypesList();
         
        for (RoomTypeCl rt : rts) { 
            try {
                saveAllotment(rt); 
                setPriceAndRestrictions(rt);
            } catch (Exception ex) {
                Logger.getLogger(AvailabilityResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
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
         
        this.setAuth( AuthHelper.doAuth(
            this.getRequest().getUsername(), 
            this.getRequest().getPassword(),  
            this.getHotelId(),
            this.getRunner())
        );
        
       this.noPrices = Constants.hasParam(
            this.getAuth().getLevel(), 
            Constants.PARAM_NO_PRICE
       ) ;
    }
 
    public AvailabilityUpdateRS getResponse() {
        if(response==null)
            response=new AvailabilityUpdateRS();
        return response;
    }
    
  
    public AvailabilityUpdateRS getEmptyResponse() {
        response=new AvailabilityUpdateRS();
        return response;
    }
    
}
