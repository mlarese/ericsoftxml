/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mmone.ericsoft.services.avail.request.RateCl;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Prices",namespace = "http://response.reservation.services.ericsoft.mmone")
public class PricesCl {
    private List<PriceCl> prices;

    @XmlElement(name="Price")
    public List<PriceCl> getPrices() {
        if(prices==null)
            prices = new ArrayList<PriceCl>();
        return prices;
    }

    public void setPrices(List<PriceCl> prices) {
        this.prices = prices;
    }
}
