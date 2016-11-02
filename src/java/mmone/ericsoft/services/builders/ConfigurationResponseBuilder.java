/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.AuthHelper;
import com.mmone.abs.api.rates.AbsMultiRateTreatment;
import com.mmone.abs.api.rates.AbsTreatment;
import com.mmone.abs.api.rates.RatePlanCrud;
import com.mmone.abs.api.room.RoomCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.exceptions.RoomLoadingErrorException;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext; 
import mmone.ericsoft.services.helper.Constants;
import mmone.ericsoft.services.rooms.request.ConfigurationRQ;
import mmone.ericsoft.services.rooms.response.ConfigurationRS;
import mmone.ericsoft.services.rooms.response.RateCl;
import mmone.ericsoft.services.rooms.response.RatesCl;
import mmone.ericsoft.services.rooms.response.RoomTypeRespCl;

/**
 *
 * @author mauro.larese
 */
public class ConfigurationResponseBuilder extends AbstractResponseBuilder<ConfigurationRQ,ConfigurationRS> {
    private ConfigurationRS response ;
    private ConfigurationRQ request ;

    public ConfigurationResponseBuilder(ConfigurationRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
         
    }
  
    @Override
    public String getHotelCodeFromRequest() {
        return getRequest().getPropertyCode();
    }
    
    private void addRates(RatesCl ret,List<AbsTreatment>treatments,Integer listId,String listCode){
        addRates(ret, treatments, listId.toString(), listCode);
    }
    private void addRates(RatesCl ret,List<AbsTreatment>treatments,String listId,String listCode){
        for (AbsTreatment treatment : treatments) { 
            String listCalcId = listId +"-"+treatment.getTreatment_id();
            String listCalcCode = listCode +"-"+treatment.getTreatment_code();
            ret.getRateList().add(new RateCl(listCalcId, listCalcCode));
        }    
    }
    private void addRate(RatesCl ret,AbsTreatment treatment,Integer listId,String listCode){ 
        addRate(ret, treatment, listId.toString(), listCode);
    }
    
    private void addRate(RatesCl ret,AbsTreatment treatment,String listId,String listCode){ 
        String listCalcId = listId +"-"+treatment.getTreatment_id();
        String listCalcCode = listCode +"-"+treatment.getTreatment_code();
        ret.getRateList().add(new RateCl(listCalcId, listCalcCode)); 
    }
    
    private RatesCl loadRates(int roomId) throws Exception{
        RatesCl ret = new RatesCl();
        List<AbsTreatment>treatments =  this.getStructureTreatments() ; 
        addRates(ret,treatments,"1","NR"); 
        
        //Force apiFull
        boolean hasApiFull =  true;
        //Constants.hasApiFull(getAuth().getLevel());
        
        if( hasApiFull ){
            List<AbsMultiRateTreatment>multiRates = RatePlanCrud.getMultiRateListAndTreatment(
                getRunner(),
                getElaborationResults(),
                getHotelId(), 
                roomId
            );
             
            logger.info(  "Loading multirates "+roomId);
            for (AbsMultiRateTreatment multiRate : multiRates) {
                //logger.info(  multiRate.getMultirate_code());
                AbsTreatment tr = new AbsTreatment(multiRate);
                addRate(ret,tr,multiRate.getMultirate_id(),multiRate.getMultirate_code()); 
            }
        } 
         
        return ret;
    }
    private void setRooms () throws RoomLoadingErrorException, Exception{
        RoomCrud rr = new RoomCrud(getHotelId(),getRunner());
        List<Map<String, Object>> rooms=rr.loadRooms();
        
        for (Map<String, Object> room : rooms) {
            int isVirtual =  (Integer)room.get("room_virtual");
             
            //if(isVirtual==1) continue;
            Integer roomId=(Integer)room.get("room_id");
            String roomDesc=(String)room.get("room_name");
            RatesCl rates = loadRates(roomId); 
            RoomTypeRespCl rtcl = new RoomTypeRespCl( roomId.toString() ,roomDesc,rates);
            
            this.getResponse().getRoomTypes().getRoomTypesList().add(rtcl);
        }
    
    }
    @Override
    public void buildResponse() {
        
        try {
            setRooms(); 
        } catch (Exception ex) {
            Logger.getLogger(ConfigurationResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            getErrors().add(new ErrType( EWT_UNKNOWN,   ERR_SYSTEM_ERROR,   "Error loading rooms"  ));
            return;
        }
    }

    @Override
    public void fillErrors() {
        
    }

    @Override
    public void fillWarnings() {
         
    }

    @Override
    public void markSuccess() {
        
    }

    @Override
    protected void authentication() throws UserNotAuthorized {
        this.setAuth(AuthHelper.doAuth(
            this.getRequest().getUsername(), 
            this.getRequest().getPassword(),  
            this.getHotelId(),
            this.getRunner())
        ); 
    }
 
    public ConfigurationRS getResponse() {
        if(response==null)
            response=new ConfigurationRS();
        return response;
    }
    
    public ConfigurationRS getEmptyResponse() {
        response=new ConfigurationRS();
        return response;
    }
}
