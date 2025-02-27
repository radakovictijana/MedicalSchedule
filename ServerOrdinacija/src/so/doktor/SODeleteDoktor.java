/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.doktor;

import broker.DBBroker;
import domen.Doktor;

import domen.OpstiDomenskiObjekat;
import domen.Pacijent;
import domen.Termin;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SODeleteDoktor extends AbstractSO{
     @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Doktor)){
            throw new Exception("Objekat nije validan");
        }
        Doktor doktor = (Doktor) obj;
       // List<Termin> termini = (List<Termin>)(List<?>)DBBroker.getInstance().getAll((new Termin()));
       
        
        
        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        DBBroker.getInstance().delete((Doktor)obj);
    }
}
