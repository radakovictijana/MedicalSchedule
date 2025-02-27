/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import controller.ServerController;
import domen.Doktor;
import domen.Izvestaj;
import domen.Pacijent;
import domen.StavkeIzvestaja;
import domen.Tehnicar;
import domen.Termin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author WIN 10
 */
public class ClientThread extends Thread{
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    

    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev klijentskiZahtev = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor serverskiOdgovor = handleRequest(klijentskiZahtev);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverskiOdgovor);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private ServerskiOdgovor handleRequest(KlijentskiZahtev klijentskiZahtev) {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();
        try{
            switch(klijentskiZahtev.getOperacija()){
                case Operacije.LOGIN:
                    Tehnicar tehnicar = (Tehnicar) klijentskiZahtev.getPodatak();
                    serverskiOdgovor.setPodatak(ServerController.getInstance().login(tehnicar));
                    break;
                case Operacije.GET_ALL_PACIJENT:
                    serverskiOdgovor.setPodatak(ServerController.getInstance().getAllPacijent());
                    break;
                case Operacije.SEARCH_PACIJENT:
                    String parametar = (String) klijentskiZahtev.getPodatak();
                    serverskiOdgovor.setPodatak(ServerController.getInstance().searchPacijent(parametar));
                    break;
                case Operacije.EDIT_PACIJENT:
                    Pacijent pac = (Pacijent) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().editPacijent(pac);
                    break;
                case Operacije.ADD_PACIJENT:
                    Pacijent pacijent2 = (Pacijent) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().addPacijent(pacijent2);
                    break;
                case Operacije.ADD_DOKTOR:
                    Doktor doktor = (Doktor) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().addDoktor(doktor);
                    break;
                case Operacije.EDIT_DOKTOR:
                    Doktor dok = (Doktor) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().editDoktor(dok);
                    break;
                case Operacije.SEARCH_DOKTOR:
                    String parametarDok = (String) klijentskiZahtev.getPodatak();
                    serverskiOdgovor.setPodatak(ServerController.getInstance().searchDoktor(parametarDok));
                    break;
                case Operacije.GET_ALL_DOKTOR:
                    serverskiOdgovor.setPodatak(ServerController.getInstance().getAllDoktor());
                    break;
                case Operacije.DELETE_DOKTOR:
                    Doktor d = (Doktor) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().deleteDoktor(d);
                    break;
                case Operacije.ADD_TERMIN:
                    Termin termin = (Termin) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().addTermin(termin);
                    break;
                
                case Operacije.DELETE_TERMIN:
                    Termin t = (Termin) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().deleteTermin(t);
                    break;
                            
                case Operacije.SEARCH_TERMIN:
                    String param = (String) klijentskiZahtev.getPodatak();
                    serverskiOdgovor.setPodatak(ServerController.getInstance().searchTermin(param));
                    break;
                case Operacije.GET_ALL_TERMIN:
                    serverskiOdgovor.setPodatak(ServerController.getInstance().getAllTermin());
                    break;
                
                case Operacije.ADD_IZVESTAJ:
                    Izvestaj izvestaj = (Izvestaj) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().addIzvestaj(izvestaj);
                    break;
                case Operacije.GET_ALL_DIJAGNOZA:
                    serverskiOdgovor.setPodatak(ServerController.getInstance().getAllDijagnoza());
                    break;
                case Operacije.DELETE_IZVESTAJ:
                    Izvestaj iz = (Izvestaj) klijentskiZahtev.getPodatak();
                    ServerController.getInstance().deleteIzvestaj(iz);
                    break;
                case Operacije.GET_ALL_IZVESTAJI:
                    serverskiOdgovor.setPodatak(ServerController.getInstance().getAllIzvestaji());
                    break;
                case Operacije.GET_ALL_STAVKE:
                    Izvestaj izves = (Izvestaj) klijentskiZahtev.getPodatak();
                    List<StavkeIzvestaja> stavkeIzv=ServerController.getInstance().getAllStavka();
                    List<StavkeIzvestaja> odg = new LinkedList<>();
                    
                    
                    for(StavkeIzvestaja stavka: stavkeIzv){
                        if(stavka.getIzvestaj().getIzvestajId()==izves.getIzvestajId()){
                            odg.add(stavka);
                        }
                    
                    }
                    serverskiOdgovor.setPodatak(odg);
                    break;
                           
                
            }
        }catch(Exception ex){
            serverskiOdgovor.setGreska(ex);
            ex.printStackTrace();
            
        }
        return serverskiOdgovor;
                
    }
    public void zaustavi(){
        
        try {
            this.interrupt();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
