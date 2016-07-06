/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.helper;

/**
 *
 * @author mauro.larese
 */
public class Constants {
    public static final int PARAM_NOT_ALLOWED = 1;
    public static final int PARAM_API_BASE = 2;
    public static final int PARAM_API_FULL = 4;
    public static final int PARAM_NO_PRICE = 8;
    public static final int PARAM_16 = 16;
    public static final int PARAM_32 = 32;
    public static final int PARAM_64 = 64;
    public static final int PARAM_128 = 128;
    public static final int PARAM_256 = 256;
    
    public  static final boolean hasParam(int value,int param){
        return ((value&param)==param) ;
    }
     
}

