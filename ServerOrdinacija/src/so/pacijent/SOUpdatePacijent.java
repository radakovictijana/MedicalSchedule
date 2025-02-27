/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pacijent;

import broker.DBBroker;
import com.mysql.cj.xdevapi.DbDoc;
import domen.Doktor;
import domen.Pacijent;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOUpdatePacijent extends AbstractSO{
    

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Pacijent)){
            throw new Exception("Objekat nije validan");
            
        }
        Pacijent pacijent = (Pacijent) obj;
        List<Pacijent> lista =(List<Pacijent>)(List<?>) DBBroker.getInstance().getAll((Pacijent)obj);
        for(Pacijent p:lista){
            if(p.getJmbg().equals(pacijent.getJmbg()) && p.getPacijentId()!=pacijent.getPacijentId()){
                 throw new Exception("Postoji pacijent sa ovim jmbg!");
            }
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        DBBroker.getInstance().update((Pacijent)obj);
    }
    
}
