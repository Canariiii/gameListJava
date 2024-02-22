package com.mycompany.accesojaxb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JuegosMain {

    private static final String GAMESTORE_XML = "./gamestore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        var gameList = new ArrayList<Juegos>();

        var game1 = new Juegos();
        game1.setName("Grand Theft Auto 6");
        game1.setPublisher("Rockstar");
        gameList.add(game1);

        var game2 = new Juegos();
        game2.setName("Fifa");
        game2.setPublisher("EA Sports");
        gameList.add(game2);
        
        var game3 = new Juegos();
        game3.setName("Call Of Duty - Modern Warfare");
        game3.setPublisher("Activision");
        gameList.add(game3);

        // create bookstore, assigning book
        var gameStore = new TiendaJuegos();
        gameStore.setName("Game");
        gameStore.setLocation("CC Las Arenas");
        gameStore.setGameList(gameList);  

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(TiendaJuegos.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(gameStore, System.out);

        // Write to File
        m.marshal(gameStore, new File(GAMESTORE_XML));

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        TiendaJuegos bookstore2 = (TiendaJuegos) um.unmarshal(new FileReader(GAMESTORE_XML));
        List<Juegos> list = bookstore2.getGamesList();  // Actualizado el nombre del método
        for (Juegos juego : list) {
            System.out.println("Game: " + juego.getName() + " from " + juego.getPublisher());
        }
    }
}
