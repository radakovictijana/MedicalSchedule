/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domen.Tehnicar;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN 10
 */
public class Sesija {
    private static Sesija instance;
    Tehnicar trenutnoUlogovan;

    public void setTrenutnoUlogovan(Tehnicar trenutnoUlogovan) {
        this.trenutnoUlogovan = trenutnoUlogovan;
    }

    public Tehnicar getTrenutnoUlogovan() {
        return trenutnoUlogovan;
    }

    public Socket getSocket() {
        return socket;
    }
    
           

    private Socket socket;
    public Sesija() {
        try {
            socket = new Socket("localhost", 10000);
        } catch (IOException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    
    public static Sesija getInstance() {
        if(instance == null){
            instance = new Sesija();
        }
        return instance;
    }
    
}
