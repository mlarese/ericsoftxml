/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.api.service.ResponseBuilder;
import com.mmone.abs.helpers.Builder;
import com.mmone.abs.helpers.exceptions.BuildErrorException;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.rooms.request.ConfigurationRQ;
import mmone.ericsoft.services.rooms.response.ConfigurationRS;
import mmone.ericsoft.services.rooms.response.RateCl;
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

    private void buildMock(){ 
        RoomTypeCl rt = new RoomTypeCl("RT001","Room 1");
        rt.getRates().add(new RateCl("RA001","Rate 001"));
        rt.getRates().add(new RateCl("RA002","Rate 002"));
        getResponse().getRoomTypes().add(rt);
    };
    @Override
    public void buildResponse() {
        buildMock();
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public ConfigurationRS getResponse() {
        if(response==null)
            response=new ConfigurationRS();
        return response;
    }
    
  
    
}
