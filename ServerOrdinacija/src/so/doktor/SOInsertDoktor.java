/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.doktor;

import broker.DBBroker;
import domen.Doktor;
import domen.OpstiDomenskiObjekat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOInsertDoktor extends AbstractSO{
    
     @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Doktor)){
            throw new Exception("Objekat nije validan");
        }
        Doktor doktor = (Doktor)obj;
        List<Doktor> lista = (List<Doktor>)(List<?>)DBBroker.getInstance().getAll((Doktor)obj);
        for(Doktor d:lista){
            if(d.getJmbg().equals(doktor.getJmbg())){
                throw new Exception("Vec postoji doktor sa datim jmbg-om");
            }
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        //Doktor doktor = (Doktor) obj;
        DBBroker.getInstance().insert((Doktor) obj);
        
        
        
    }
    
}
