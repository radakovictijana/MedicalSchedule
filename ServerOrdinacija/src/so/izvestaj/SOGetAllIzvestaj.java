/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izvestaj;

import broker.DBBroker;
import domen.Izvestaj;
import java.util.LinkedList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOGetAllIzvestaj extends AbstractSO{

    List<Izvestaj> lista;

    public List<Izvestaj> getLista() {
        return lista;
    }
    
    
    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Izvestaj)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Izvestaj>)(List<?>)DBBroker.getInstance().getAll((Izvestaj)obj);
    }
    
}
