/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.dijagnoza;

import broker.DBBroker;
import domen.Dijagnoza;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOGetAllDijagnoza extends  AbstractSO{
    
    List<Dijagnoza> lista;

    public List<Dijagnoza> getLista() {
        return lista;
    }
    

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Dijagnoza)){
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista = (List<Dijagnoza>) (List<?>) DBBroker.getInstance().getAll((Dijagnoza)obj);
    }
    
    
}
