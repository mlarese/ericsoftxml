/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmone.ericsoft.services.reservation.response;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author maurolarese
 */
@XmlType(name="Booker",namespace = "http://response.reservation.services.ericsoft.mmone")
public class BookerCl {
     private String name;
     private String surname;
     private String email;
     private String address;
     private String city;
     private String cap;
     private String countryIsoCode;
     private String telephone;
     private String notes;
     //private CreditCardCl creditCard;

    @XmlElement(name="Name") 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="Surname") 
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @XmlElement(name="Email") 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement(name="Address") 
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @XmlElement(name="City") 
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(name="Cap") 
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }
    @XmlElement(name="CountryIsoCode") 
    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }
    @XmlElement(name="Telephone") 
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @XmlElement(name="Notes") 
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    /*
    @XmlElement(name="CreditCard") 
    public CreditCardCl getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardCl creditCard) {
        this.creditCard = creditCard;
    }*/
    
    
}
