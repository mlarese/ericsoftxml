/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.builders;

import com.mmone.abs.api.auth.AuthHelper;
import com.mmone.abs.api.reservation.ReservationCrud;
import com.mmone.abs.api.service.AbstractResponseBuilder;
import com.mmone.abs.helpers.ElaborationResultError;
import com.mmone.abs.helpers.ErrType;
import com.mmone.abs.helpers.dates.DateHelper;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.xml.ws.WebServiceContext; 
import mmone.ericsoft.services.reservation.request.ReservationRetrievalRQ;
import mmone.ericsoft.services.reservation.response.BookerCl;
import mmone.ericsoft.services.reservation.response.ReservationCl;
import mmone.ericsoft.services.reservation.response.ReservationRetrievalRS;
import mmone.ericsoft.services.reservation.response.ReservationsCl;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

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
        return getRequest().getPropertyCode();
    }
 
    @Override
    public void buildResponse() {
        int portal=1;
        ReservationsCl rs=getResponse().getReservations();
        Date lastChange=null;
        
        if(  !StringUtils.isEmpty(getRequest().getLastChange())   ){
            try {      
                lastChange=DateUtils.parseDate(getRequest().getLastChange(),DateHelper.dateParsers )   ;
            } catch (ParseException ex) {
                Logger.getLogger(ReservationRetrievalResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            List<Map<String, Object>> reservations=ReservationCrud.retrieveReservations(getRunner(),
                    getHotelCode(),
                    ReservationCrud.getDownloadContext(getHotelCodeFromRequest()),
                    portal);
            
            
            int reservationCount = 0;
            for (Map<String, Object> reservation : reservations) {
                if(lastChange!=null){
                    try {
                        if( lastChange.compareTo(  (Date)reservation.get("reservation_status_date")    )>0 ) continue;
                    } catch (Exception e) { }
                    
                }
                
                reservationCount++;
                if(reservationCount>ReservationCrud.DOWNLOAD_LIMIT) break;
                Integer reservationId = new Integer(reservation.get("reservation_id").toString());
                Integer currentPortalId = new Integer(reservation.get("portal_id").toString());
                if(currentPortalId==null) currentPortalId=1;
                
                try{
                    List<Map<String, Object>> reservationDetails = ReservationCrud.loadReservationOtherData(getRunner(), reservationId) ;
                    List<Map<String, Object>> reservationRoomData = ReservationCrud.loadReservationRoomData(getRunner(), reservationId) ;                    
                    ReservationCl r = ReservationBuilder.build(reservation, reservationDetails, reservationRoomData);
                    
                    rs.getReservations().add(r);
                    
                }catch(Exception e){
                    logger.log(
                        Level.SEVERE 
                        , "Error adding reservation"
                          + "\n - Structure : " + getHotelCode()
                          + "\n - Reservation : " + reservationId 
                    );
                    
                }
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationRetrievalResponseBuilder.class.getName()).log(Level.SEVERE, null, ex);
            getElaborationResults().addError(ERR_SYSTEM_ERROR, "Error loading requests", EWT_UNKNOWN);
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
    public ReservationRetrievalRS getResponse() {
        if(response==null)
            response=new ReservationRetrievalRS();
        return response;
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
    
}
