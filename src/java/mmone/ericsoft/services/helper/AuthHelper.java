/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.helper;

import com.mmone.abs.api.auth.Authenticator;
import com.mmone.abs.helpers.exceptions.UserNotAuthorized;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author mauro.larese
 */
public class AuthHelper {
    public static Authenticator.AuthRecord doAuth(String user,String pwd, int hotelId,QueryRunner run) throws UserNotAuthorized{
        Authenticator au = new Authenticator(user, pwd,hotelId, run  );
        
        Authenticator.AuthRecord ar =  au.doAbsAuth();
        
        if(!ar.isAuthenticated()){
            throw new UserNotAuthorized("User Not Authorized");
        }
        
        return (ar);
    }
}
