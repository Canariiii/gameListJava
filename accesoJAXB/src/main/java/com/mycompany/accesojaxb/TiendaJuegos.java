package com.mycompany.accesojaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.company.xml.accesojaxb.gradle.model")
public class TiendaJuegos {

    @XmlElementWrapper(name = "gamesList")
    @XmlElement(name = "game")
    private List<Juegos> gameList;
    private String name;
    private String location;

    public void setGameList(List<Juegos> bookList) {
        this.gameList = bookList;
    }

    public List<Juegos> getGamesList() {
        return gameList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
