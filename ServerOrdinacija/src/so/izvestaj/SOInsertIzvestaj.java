/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izvestaj;

import broker.DBBroker;
import domen.Izvestaj;
import domen.Pacijent;
import domen.StavkeIzvestaja;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOInsertIzvestaj extends AbstractSO{

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Izvestaj)){
            throw new Exception("Objekat nije validan");
        }
        Izvestaj izvestaj= (Izvestaj)obj;
        List<Izvestaj> lista = (List<Izvestaj>)(List<?>)DBBroker.getInstance().getAll((Izvestaj)obj);
        //for(Izvestaj i:lista){
        if(lista.contains(obj)){
            throw  new Exception("Postoji ovaj izvestaj");
        }
        

          
        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        Izvestaj izvestaj = (Izvestaj) obj;
        DBBroker.getInstance().insert(izvestaj);
        for(StavkeIzvestaja stavka: izvestaj.getStavkaIzvestaje()){
            DBBroker.getInstance().insert(stavka);
                    
        }
    }
    
}
