/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.avail.request;

import mmone.ericsoft.services.rooms.response.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name = "Periods")
public class PeriodsCl {
    private List<PeriodCl> periods;
    @XmlElement(name="Period")
    public List<PeriodCl> getPeriodList() {
        if(periods==null)
            periods = new ArrayList<PeriodCl>();
        return periods;
    }

    public void setPeriodList(List<PeriodCl> periods) {
        this.periods = periods;
    }
}
