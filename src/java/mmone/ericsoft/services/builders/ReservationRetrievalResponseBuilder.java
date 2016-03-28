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
import mmone.ericsoft.services.reservation.request.ReservationRetrievalRQ;
import mmone.ericsoft.services.reservation.response.ReservationRetrievalRS;

/**
 *
 * @author maurolarese
 */
public class ReservationRetrievalResponseBuilder extends AbstractResponseBuilder<ReservationRetrievalRQ, ReservationRetrievalRS>{
    private ReservationRetrievalRS response ;
    private ReservationRetrievalRQ request ;

    public ReservationRetrievalResponseBuilder( ReservationRetrievalRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
        this.request = request;
    }
    
    
    @Override
    public String getHotelCodeFromRequest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildResponse() {
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
    public ReservationRetrievalRS getResponse() {
        return response;
    }

    @Override
    protected void authentication() throws UserNotAuthorized {
    }
    
}
