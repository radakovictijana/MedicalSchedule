/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pacijent;

import broker.DBBroker;
import domen.Pacijent;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOGetAllPacijent extends AbstractSO{

    List<Pacijent> lista;

    public List<Pacijent> getLista() {
        return lista;
    }

    
    
    
    @Override
    protected void execute(Object obj) throws Exception {
       lista =(List<Pacijent>)(List<?>) DBBroker.getInstance().getAll((Pacijent)obj);
    }

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Pacijent)){
            throw new Exception("Objekat nije validan!");
        }
    }
    
    
}
