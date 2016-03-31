/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.reservation.ReservationCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.ElaborationResultError;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.reservation.request.ReservationConfirmationRQ;
import mmone.ericsoft.services.reservation.response.ReservationConfirmationRS;

/**
 *
 * @author maurolarese
 */
public class ReservationConfirmationlResponseBuilder extends AbstractResponseBuilder<ReservationConfirmationRQ, ReservationConfirmationRS>{
    private ReservationConfirmationRS response ;
    private ReservationConfirmationRQ request ;

    public ReservationConfirmationlResponseBuilder( ReservationConfirmationRQ request, WebServiceContext webServiceContext, InitialContext initialContext) {
        super(request, webServiceContext, initialContext);
        this.request = request;
    }
    
    
    @Override
    public String getHotelCodeFromRequest() {
        return getRequest().getPropertyCode();
    }
 
    private String getDownloadContext(){
        return ReservationCrud.getDownloadContext(getHotelCodeFromRequest());
    }
  
    @Override
    public void buildResponse() {
        try {
            String id = getRequest().getReservations().getReservation().getId();
            ReservationCrud.insertOrUpdateDownloadRecord(getRunner(), getDownloadContext(), id, id);
        } catch (Exception ex) {
            Logger.getLogger(ReservationConfirmationlResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void fillErrors() {
        if(getElaborationResults().getErrors().size()>0){
            ElaborationResultError er =  getElaborationResults().getErrors().get(0);
            getErrors().add(new ErrType(er.getDescription()));
        }
    }

    @Override
    public void fillWarnings() {
    }

    @Override
    public void markSuccess() {
    }

    @Override
    public ReservationConfirmationRS getResponse() {
        if(response==null)
            response=new ReservationConfirmationRS();
        return response;
    }

    @Override
    protected void authentication() throws UserNotAuthorized {
    }
    
}