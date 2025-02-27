/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import broker.DBBroker;
import domen.Termin;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOSearchTermin extends AbstractSO{
    List<Termin> lista;

    public List<Termin> getLista() {
        return lista;
    }
    

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof String)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Termin>)(List<?>)DBBroker.getInstance().search(new Termin(), (String) obj);
    }
    
}
