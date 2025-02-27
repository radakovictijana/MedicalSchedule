/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import broker.DBBroker;
import domen.Termin;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SODeleteTermin extends AbstractSO{

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Termin)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        Termin termin = (Termin) obj;
        
        
        DBBroker.getInstance().delete(termin);

            
    }
    
    
}
