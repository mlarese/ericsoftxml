/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.service.ResponseBuilder;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext; 
import mmone.ericsoft.services.rooms.request.ConfigurationRQ;
import mmone.ericsoft.services.rooms.response.ConfigurationRS;

/**
 *
 * @author mauro.larese
 */
public class ResponseBuilderFactory{
    private ResponseBuilder builder;
    public ResponseBuilder getBuilder() {
        return builder;
    }
    public ResponseBuilderFactory (ConfigurationRQ request, WebServiceContext webServiceContext, InitialContext initialContext){
        builder = new ConfigurationResponseBuilder(request, webServiceContext, initialContext); 
    }
}
