/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.error.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Errors",namespace = "http://response.error.services.ericsoft.mmone")
public class ErrorsCl { 
    private String Error;

    @XmlElement(name = "Error")
    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }
    
    
}
