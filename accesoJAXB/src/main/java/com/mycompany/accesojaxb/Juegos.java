package com.mycompany.accesojaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "game")
@XmlType(propOrder = { "name", "publisher" })
public class Juegos {
    private String name;
    private String publisher;

    
    @XmlElement(name = "title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
