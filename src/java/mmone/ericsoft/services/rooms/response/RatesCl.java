/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.rooms.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name = "Rates")
public class RatesCl {
    private List<RateCl> rates;
    @XmlElement(name="Rate")
    public List<RateCl> getRateList() {
        if(rates==null)
            rates = new ArrayList<RateCl>();
        return rates;
    }

    public void setRateList(List<RateCl> rates) {
        this.rates = rates;
    }
}
