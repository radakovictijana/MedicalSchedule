/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.doktor;

import broker.DBBroker;
import domen.Doktor;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOgetAllDoktor extends AbstractSO{

    List<Doktor> lista;

    public List<Doktor> getLista() {
        return lista;
    }
    
    
    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Doktor)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Doktor>) (List<?>) DBBroker.getInstance().getAll((Doktor) obj);
    }
    
    
}
