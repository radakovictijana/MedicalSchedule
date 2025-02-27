/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import broker.DBBroker;
import domen.Dijagnoza;
import domen.StavkeIzvestaja;
import domen.Doktor;
import domen.Izvestaj;
import domen.Pacijent;
import domen.Tehnicar;
import domen.Termin;
import java.util.List;
import niti.ClientThread;
import so.dijagnoza.SOGetAllDijagnoza;
import so.doktor.SODeleteDoktor;
import so.doktor.SOInsertDoktor;
import so.doktor.SOSearchDoktor;
import so.doktor.SOUpdateDoktor;
import so.doktor.SOgetAllDoktor;
import so.izvestaj.SODeleteIzvestaj;
import so.izvestaj.SOGetAllIzvestaj;
import so.izvestaj.SOInsertIzvestaj;
import so.pacijent.SOGetAllPacijent;
import so.pacijent.SOInsertPacijent;
import so.pacijent.SOSearchPacijent;
import so.pacijent.SOUpdatePacijent;
import so.stavkaIzvestaja.SOGetAllStavkaIzvestaja;
import so.tehnicar.SOGetAllTehnicar;
import so.termin.SODeleteTermin;
import so.termin.SOGetAllTermin;
import so.termin.SOInsertTermin;
import so.termin.SOSearchTermin;

/**
 *
 * @author WIN 10
 */
public class ServerController {
    private static ServerController instance;

            

    public ServerController() {
        
    }

    
    public static ServerController getInstance() {
        if(instance == null){
            instance  = new ServerController();
        }
        return instance;
    }

    public List<Pacijent> getAllPacijent() throws Exception {
        SOGetAllPacijent sOGetAllPacijent = new SOGetAllPacijent();
        sOGetAllPacijent.templateExecute(new Pacijent());
        return sOGetAllPacijent.getLista();
    }

    public List<Pacijent> searchPacijent(String parametar) throws Exception {
        SOSearchPacijent so = new SOSearchPacijent();
        so.templateExecute(parametar);
        return so.getLista();
        
    }

    public Tehnicar login(Tehnicar tehnicar) throws Exception {
        SOGetAllTehnicar sOGetAllTehnicar = new SOGetAllTehnicar();
        sOGetAllTehnicar.templateExecute(new Tehnicar());
        List<Tehnicar> lista = sOGetAllTehnicar.getLista();
        
        for(Tehnicar tehnicar1: lista){
            if(tehnicar1.getKorisnickoIme().equals(tehnicar.getKorisnickoIme()) && tehnicar1.getLozinka().equals(tehnicar.getLozinka()))
                return tehnicar1;
            
        }
        throw new Exception("Sistem ne može da tehnicara nalog na osnovu unetih vrednosti!");

    }

    public void editPacijent(Pacijent pacijent) throws Exception {
        SOUpdatePacijent soup = new SOUpdatePacijent();
        soup.templateExecute(pacijent);
        
    }

  
    public void addPacijent(Pacijent pacijent) throws Exception {
        SOInsertPacijent sOInsertPacijent = new SOInsertPacijent();
        sOInsertPacijent.templateExecute(pacijent);
        
                
    }

    public void addDoktor(Doktor doktor) throws Exception {
        SOInsertDoktor sOInsertDoktor = new SOInsertDoktor();
        sOInsertDoktor.templateExecute(doktor);
                
    }

    public void editDoktor(Doktor dok) throws Exception {
        SOUpdateDoktor so = new SOUpdateDoktor();
        so.templateExecute(dok);
    }

    public List<Doktor> searchDoktor(String parametar) throws Exception {
        SOSearchDoktor so = new SOSearchDoktor();
        so.templateExecute(parametar);
        return so.getLista();
    }

    public List<Doktor> getAllDoktor() throws Exception {
        SOgetAllDoktor so = new SOgetAllDoktor();
        so.templateExecute(new Doktor());
        return so.getLista();
                
    }

    public void deleteDoktor(Doktor doktor) throws Exception {
        SODeleteDoktor so = new SODeleteDoktor();
        so.templateExecute(doktor);
        
    }

    public void addTermin(Termin termin)throws Exception {
        SOInsertTermin so = new SOInsertTermin();
        so.templateExecute(termin);
    }

    

    public void deleteTermin(Termin termin) throws Exception {
        SODeleteTermin so = new SODeleteTermin();
        so.templateExecute(termin);
    }

    public List<Termin> searchTermin(String param) throws Exception {
        SOSearchTermin so = new SOSearchTermin();
        so.templateExecute(param);
        return so.getLista();
    }

    public List<Termin> getAllTermin() throws Exception {
        SOGetAllTermin so = new SOGetAllTermin();
        so.templateExecute(new Termin());
        return so.getLista();
    }

  

    public void addIzvestaj(Izvestaj izvestaj)throws Exception {
        SOInsertIzvestaj so = new SOInsertIzvestaj();
        so.templateExecute(izvestaj);
        
    }
    public List<Dijagnoza> getAllDijagnoza() throws Exception{
        SOGetAllDijagnoza so = new SOGetAllDijagnoza();
        so.templateExecute(new Dijagnoza());
        return so.getLista();
    }

    public void deleteIzvestaj(Izvestaj izvestaj) throws Exception {
        SODeleteIzvestaj so = new SODeleteIzvestaj();
        so.templateExecute(izvestaj);
        
    }

    public List<Izvestaj> getAllIzvestaji() throws Exception{
        SOGetAllIzvestaj so = new SOGetAllIzvestaj();
        so.templateExecute(new Izvestaj());
        return so.getLista();

    }

    public List<StavkeIzvestaja> getAllStavka() throws Exception{
        SOGetAllStavkaIzvestaja so = new SOGetAllStavkaIzvestaja();
        so.templateExecute(new StavkeIzvestaja());
        return so.getLista();
    }

   

   
    
    
    
    
}
