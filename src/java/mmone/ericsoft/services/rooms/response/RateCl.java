/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.rooms.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author maurolarese
 */
@XmlType(name = "Rate",namespace = "http://response.rooms.services.ericsoft.mmone")
public class RateCl { 
    private String id; 
    private String description; 
    private String parent;
    public RateCl(String id, String description) {
        this.id = id;
        this.description = description;
    }
    public RateCl(String id, String parent, String description) {
        this.id = id;
        this.parent = parent;
        this.description = description;
    }
    public RateCl() {
    }  
    @XmlAttribute(name="Id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlAttribute(name="Parent")
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    @XmlElement(name="Description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

