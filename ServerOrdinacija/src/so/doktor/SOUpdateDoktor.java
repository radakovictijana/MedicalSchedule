/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.doktor;

import broker.DBBroker;
import domen.Doktor;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOUpdateDoktor extends AbstractSO{
     @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Doktor)){
            throw new Exception("Objekat nije validan");
        }
       List<Doktor> lista = (List<Doktor>)(List<?>)DBBroker.getInstance().getAll((Doktor)obj);
       
        Doktor doktor = (Doktor) obj;
        for(Doktor dok: lista){
            if(dok.getDoktorId()!=doktor.getDoktorId() && dok.getJmbg().equals(doktor.getJmbg())){
                throw new Exception("Vec postoji doktor sa ovim jbmgog");
            }
        }
        

    }

    @Override
    protected void execute(Object obj) throws Exception {
        DBBroker.getInstance().update((Doktor)obj);
    }
}
