/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import broker.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN 10
 */
public abstract class AbstractSO {
   

    public final void templateExecute(Object obj)throws Exception{
        try {
            validate(obj);
            execute(obj);
            commit();
        } catch (Exception ex) {
            Logger.getLogger(AbstractSO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            rollback();
            throw ex;
        }
        
    }
    protected abstract void validate(Object obj) throws Exception;

    protected abstract void execute(Object obj) throws Exception;
    
    public void commit() throws Exception{
       DBBroker.getInstance().getKonekcija().commit();
        
    }
    public void rollback() throws Exception{
       DBBroker.getInstance().getKonekcija().rollback();
    }
    
}
