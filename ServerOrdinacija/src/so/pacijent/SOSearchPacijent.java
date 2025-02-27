/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pacijent;

import broker.DBBroker;
import domen.Doktor;
import domen.Pacijent;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOSearchPacijent extends AbstractSO{
    List<Pacijent> lista;

    public List<Pacijent> getLista() {
        return lista;
    }
    

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof String)){
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Pacijent>)(List<?>)DBBroker.getInstance().search(new Pacijent(), (String) obj);
    }
    
}
