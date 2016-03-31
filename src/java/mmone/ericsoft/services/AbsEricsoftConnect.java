/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services;

import com.mmone.abs.helpers.Builder;
import com.mmone.abs.helpers.exceptions.BuildErrorException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.WebServiceContext;
import mmone.ericsoft.services.avail.request.AvailabilityUpdateRQ;
import mmone.ericsoft.services.avail.response.AvailabilityUpdateRS;
import mmone.ericsoft.services.builders.ResponseBuilderFactory;
import mmone.ericsoft.services.reservation.request.ReservationConfirmationRQ;
import mmone.ericsoft.services.reservation.request.ReservationRetrievalRQ;
import mmone.ericsoft.services.reservation.response.ReservationConfirmationRS;
import mmone.ericsoft.services.reservation.response.ReservationRetrievalRS;
import mmone.ericsoft.services.rooms.request.ConfigurationRQ; 
import mmone.ericsoft.services.rooms.response.ConfigurationRS;

/**
 *
 * @author mauro.larese
 */
@WebService(name = "AbsEricsoftConnect")
@SOAPBinding(style=SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED  )
public class AbsEricsoftConnect {
    @Resource
    private WebServiceContext wsc;
    private InitialContext getContext()  { 
        try {    
            return new InitialContext(); 
        } catch (NamingException ex) { 
            Logger.getLogger(AbsEricsoftConnect.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    } 
    @WebMethod(operationName="ConfigurationAction") 
    @WebResult(name="ConfigurationResponse")
    public ConfigurationRS getConfiguration(@WebParam(name = "ConfigurationRequest") ConfigurationRQ request) {
        ResponseBuilderFactory fact = new ResponseBuilderFactory(request, wsc, getContext());
        Builder<ConfigurationRS> b =  fact.getBuilder();  
        try {
            return b.build(); 
        } catch (BuildErrorException ex) {
            Logger.getLogger(AbsEricsoftConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AvailabilityUpdateAction")
    @WebResult(name="AvailabilityUpdateResponse")
    public AvailabilityUpdateRS AvailabilityUpdateAction(@WebParam(name = "AvailabilityUpdateRequest") AvailabilityUpdateRQ request) {
        ResponseBuilderFactory fact = new ResponseBuilderFactory(request, wsc, getContext());
        Builder<AvailabilityUpdateRS> b =  fact.getBuilder();  
        try {
            return b.build(); 
        } catch (BuildErrorException ex) {
            Logger.getLogger(AbsEricsoftConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReservationRetrievalAction")
    @WebResult(name="ReservationRetrievalResponse")
    public ReservationRetrievalRS ReservationRetrievalAction(@WebParam(name = "ReservationRetrievalRequest") ReservationRetrievalRQ request) {
        ResponseBuilderFactory fact = new ResponseBuilderFactory(request, wsc, getContext());
        Builder<ReservationRetrievalRS> b =  fact.getBuilder();  
        try {
            return b.build(); 
        } catch (BuildErrorException ex) {
            Logger.getLogger(AbsEricsoftConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "ReservationConfirmationAction")
    @WebResult(name = "ReservationConfirmationResponse")
    public ReservationConfirmationRS ReservationConfirmationRS(@WebParam(name = "ReservationConfirmationRequest") ReservationConfirmationRQ request) {
        ResponseBuilderFactory fact = new ResponseBuilderFactory(request, wsc, getContext());
        Builder<ReservationConfirmationRS> b = fact.getBuilder();        
        try {
            return b.build();            
        } catch (BuildErrorException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
