/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import broker.DBBroker;
import com.mysql.cj.protocol.Resultset;
import domen.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author WIN 10
 */
public class SOInsertTermin extends AbstractSO{

    @Override
    protected void validate(Object obj) throws Exception {
        if(!(obj instanceof Termin)){
            throw new Exception("Objekat nije validan");
        }
        Termin termin = (Termin) obj;
        List<Termin> listaTermina = (List<Termin>)(List<?>) DBBroker.getInstance().getAll(termin);
        for(Termin ter: listaTermina){
            if(ter.getDatum().equals(termin.getDatum())){
                throw new Exception("Vec postoji termin za dati datum i vreme!"+termin.getDatum());
            }
        }
        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        //Termin termin = (Termin) obj;
        DBBroker.getInstance().insert((Termin)obj);
       
       
    }
    
    
}

