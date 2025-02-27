/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkaIzvestaja;

import broker.DBBroker;
import domen.StavkeIzvestaja;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOGetAllStavkaIzvestaja extends AbstractSO{
    List<StavkeIzvestaja> lista;

    public List<StavkeIzvestaja> getLista() {
        return lista;
    }

    
   

    @Override
    protected void validate(Object obj) throws Exception {
          if(!(obj instanceof StavkeIzvestaja)){
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        lista =(List<StavkeIzvestaja>)(List<?>) DBBroker.getInstance().getAll((StavkeIzvestaja)obj);
    }
    
    
}
