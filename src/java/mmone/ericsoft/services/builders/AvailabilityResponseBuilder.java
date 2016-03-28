/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.avail.request.AvailabilityUpdateRQ;
import mmone.ericsoft.services.avail.response.AvailabilityUpdateRS;

/**
 *
 * @author mauro.larese
 */
public class AvailabilityResponseBuilder extends AbstractResponseBuilder<AvailabilityUpdateRQ,AvailabilityUpdateRS> {
    private AvailabilityUpdateRS response ;
    private AvailabilityUpdateRQ request ;

    public AvailabilityResponseBuilder(AvailabilityUpdateRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
        setMock(true);
    }
  
    @Override
    public String getHotelCodeFromRequest() {
        return getRequest().getPropertyCode();
    }

    private void buildMock(){ 
        
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
 
    public AvailabilityUpdateRS getResponse() {
        if(response==null)
            response=new AvailabilityUpdateRS();
        return response;
    }
    
  
    
}