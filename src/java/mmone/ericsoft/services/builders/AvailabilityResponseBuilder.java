/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.Authenticator;
import com.mmone.abs.api.room.RoomCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.util.List;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.avail.request.AvailabilityUpdateRQ;
import mmone.ericsoft.services.avail.request.RoomTypeCl;
import mmone.ericsoft.services.avail.request.RoomTypesCl;
import mmone.ericsoft.services.avail.response.AvailabilityUpdateRS;
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
 
    @Override
    public void buildResponse() {
        List<RoomTypeCl> rts = getRequest().getRoomTypes().getRoomTypesList();
        
        for (RoomTypeCl rt : rts) {
             
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
 
    public AvailabilityUpdateRS getResponse() {
        if(response==null)
            response=new AvailabilityUpdateRS();
        return response;
    }
    
  
    
}
