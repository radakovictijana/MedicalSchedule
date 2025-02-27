/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public abstract class OpstiDomenskiObjekat implements Serializable{
    
    public abstract String vratiImeTabele();
    public abstract  List<OpstiDomenskiObjekat> vratiListu(ResultSet rs)throws SQLException;
    public abstract String vratiUslovZaJoin();
    public abstract void postaviId(Integer id);
    public abstract String id();
    public abstract String vratiUslovZaPretragu(String parametar);
    public abstract String vratiNaziveKolonaZaInsert();
    public abstract String vratiVrednostiZaInsert();
    public abstract String vratiVrednostiZaUpdate();
    public abstract String primarniKljuc();
    public abstract boolean isAuto();

    
}
