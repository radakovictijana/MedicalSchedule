/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tehnicar;

import broker.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Tehnicar;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOGetAllTehnicar extends AbstractSO{

    private List<Tehnicar> lista;

    public List<Tehnicar> getLista() {
        return lista;
    }
    
    
    
    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Tehnicar)){
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Tehnicar>) (List<?>) DBBroker.getInstance().getAll((Tehnicar) obj);
    }
    
    
}
