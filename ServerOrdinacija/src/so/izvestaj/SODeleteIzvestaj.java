/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izvestaj;

import broker.DBBroker;
import domen.Izvestaj;
import domen.OpstiDomenskiObjekat;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SODeleteIzvestaj extends AbstractSO{

    
    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Izvestaj)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        Izvestaj izvestaj = (Izvestaj)obj;
        if(!izvestaj.getStavkaIzvestaje().isEmpty()){        
            DBBroker.getInstance().delete(izvestaj.getStavkaIzvestaje().get(0));
        }
        DBBroker.getInstance().delete((Izvestaj) obj);
        
        
    }
    
}
