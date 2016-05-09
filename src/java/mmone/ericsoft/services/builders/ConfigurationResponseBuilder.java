/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.AuthHelper;
import com.mmone.abs.api.auth.Authenticator;
import com.mmone.abs.api.rates.AbsTreatment;
import com.mmone.abs.api.rates.RatePlanCrud;
import com.mmone.abs.api.room.RoomCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.exceptions.RoomLoadingErrorException;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext; 
import mmone.ericsoft.services.rooms.request.ConfigurationRQ;
import mmone.ericsoft.services.rooms.response.ConfigurationRS;
import mmone.ericsoft.services.rooms.response.RateCl;
import mmone.ericsoft.services.rooms.response.RatesCl;
import mmone.ericsoft.services.rooms.response.RoomTypeCl;

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
    
    private void addRates(RatesCl ret,List<AbsTreatment>treatments,String listId,String listCode){
        for (AbsTreatment treatment : treatments) { 
            String listCalcId = listId +"-"+treatment.getTreatment_id();
            String listCalcCode = listCode +"-"+treatment.getTreatment_code();
            ret.getRateList().add(new RateCl(listCalcId, listCalcCode));
        }    
    }
    private RatesCl loadRates(int roomId){
        RatesCl ret = new RatesCl();
        List<AbsTreatment>treatments;
        try {
            treatments = RatePlanCrud.getTreatments(
                    this.getRunner(),
                    this.getElaborationResults(),
                    this.getHotelId());
        } catch (Exception ex) {
            Logger.getLogger(ConfigurationResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            AbsTreatment t = new AbsTreatment();
            t.setTreatment_code("BB");
            t.setTreatment_id(2);
            t.setTreatment_name("Bed and breakfast");
            treatments = new ArrayList<AbsTreatment>();
            treatments.add(t);
        }
                 
        addRates(ret,treatments,"1","NR");
        
        if(getAuth().getLevel()==API_FULL){
        
        }
        
        return ret;
    }
    private void setRooms () throws RoomLoadingErrorException{
        RoomCrud rr = new RoomCrud(getHotelId(),getRunner());
        List<Map<String, Object>> rooms=rr.loadRooms();
        
        for (Map<String, Object> room : rooms) {
            Integer roomId=(Integer)room.get("room_id");
            String roomDesc=(String)room.get("room_name");
            RatesCl rates = loadRates(roomId);
            RoomTypeCl rtcl = new RoomTypeCl( roomId.toString() ,roomDesc,rates);
            
            this.getResponse().getRoomTypes().getRoomTypesList().add(rtcl);
        }
    
    }
    @Override
    public void buildResponse() {
        
        try {
            setRooms(   );
        } catch (RoomLoadingErrorException ex) {
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
