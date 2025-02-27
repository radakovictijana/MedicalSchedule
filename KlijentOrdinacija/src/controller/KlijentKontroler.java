/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.Dijagnoza;
import domen.StavkeIzvestaja;
import domen.Doktor;
import domen.Izvestaj;
import domen.Pacijent;
import domen.Tehnicar;
import domen.Termin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import konstante.Operacije;
import session.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author WIN 10
 */
public class KlijentKontroler {
    private static KlijentKontroler instance;

    
    
    public static KlijentKontroler getInstance() throws IOException {
        if(instance == null){
            instance = new KlijentKontroler();
        }
        return instance;
    }

    public KlijentKontroler() throws IOException {
        
        
    }
    private Object sendRequest(int operacija, Object podatak) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev(operacija, podatak);
        out.writeObject(klijentskiZahtev);
        ObjectInputStream in = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor serverskiOdgovor  = (ServerskiOdgovor)in.readObject();
        
        if(serverskiOdgovor.getGreska()!= null){
            throw serverskiOdgovor.getGreska();
        }
        return serverskiOdgovor.getPodatak();
        
    }

    public Tehnicar login(Tehnicar tehnicar) throws Exception{
        return (Tehnicar) sendRequest(Operacije.LOGIN, tehnicar);
        
        
    }

    public List<Pacijent> getAllPacijenti() throws Exception {
        return (List<Pacijent>) sendRequest(Operacije.GET_ALL_PACIJENT, null);
    }

    public List<Pacijent> searchPacijent(String parametar) throws Exception{
        return (List<Pacijent>) sendRequest(Operacije.SEARCH_PACIJENT, parametar);
    }

    public void addPacijent(Pacijent pacijent) throws Exception {
        sendRequest(Operacije.ADD_PACIJENT, pacijent);
    }

    public void editPacijent(Pacijent pacijent) throws Exception {
        sendRequest(Operacije.EDIT_PACIJENT, pacijent);
    }

    public List<Doktor> getAllDoktor() throws Exception {
        return (List<Doktor>) sendRequest(Operacije.GET_ALL_DOKTOR, null);
        
    }

    public List<Doktor> searchDoktor(String parametar) throws Exception {
        return (List<Doktor>) sendRequest(Operacije.SEARCH_DOKTOR, parametar);
    }

    public void deleteDoktor(Doktor doktor) throws Exception {
        sendRequest(Operacije.DELETE_DOKTOR, doktor);
    }

    public void addDoktor(Doktor doktor) throws Exception {
        sendRequest(Operacije.ADD_DOKTOR, doktor);
    }

    public void editDoktor(Doktor doktor) throws Exception {
        sendRequest(Operacije.EDIT_DOKTOR, doktor);
    }

    public void addTermin(Termin termin)throws Exception {
        sendRequest(Operacije.ADD_TERMIN, termin);
    }

   

    public List<Termin> getAllTermin() throws Exception {
        return (List<Termin>) sendRequest(Operacije.GET_ALL_TERMIN, null);
    }

    public List<Termin> searchTermin(String parametar) throws Exception {
        return (List<Termin>) sendRequest(Operacije.SEARCH_TERMIN, parametar);
    }

    public void deleteTermin(Termin termin)throws Exception {
        sendRequest(Operacije.DELETE_TERMIN, termin);
    }

    public List<StavkeIzvestaja> getAllStavke(Izvestaj izvestaj) throws Exception {
        return (List<StavkeIzvestaja>) sendRequest(Operacije.GET_ALL_STAVKE, izvestaj);
    }

    public void addIzvestaj(Izvestaj izvestaj)throws Exception {
        sendRequest(Operacije.ADD_IZVESTAJ, izvestaj);
    }

    public List<Dijagnoza> getAllDijagnoza() throws Exception {
        return (List<Dijagnoza>) sendRequest(Operacije.GET_ALL_DIJAGNOZA, null);
        
    }

    public List<Izvestaj> getAllIzvestaj() throws Exception {
        return (List<Izvestaj>) sendRequest(Operacije.GET_ALL_IZVESTAJI, null);
    }

    public void deleteIzvestaj(Izvestaj izvestaj) throws Exception {
        sendRequest(Operacije.DELETE_IZVESTAJ, izvestaj);
    }

  

   

    
    
    
}
