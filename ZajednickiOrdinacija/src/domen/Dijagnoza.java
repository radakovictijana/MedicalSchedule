/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class Dijagnoza extends OpstiDomenskiObjekat implements Serializable{
    
    private int dijagnozaId;
    private String nazivDijagnoze;
    private String sifra;

    public Dijagnoza() {
    }

    public Dijagnoza(int dijagnozaId, String nazivDijagnoze, String sifra) {
        this.dijagnozaId = dijagnozaId;
        this.nazivDijagnoze = nazivDijagnoze;
        this.sifra = sifra;
    }

    public int getDijagnozaId() {
        return dijagnozaId;
    }

    public void setDijagnozaId(int dijagnozaId) {
        this.dijagnozaId = dijagnozaId;
    }

    public String getNazivDijagnoze() {
        return nazivDijagnoze;
    }

    public void setNazivDijagnoze(String nazivDijagnoze) {
        this.nazivDijagnoze = nazivDijagnoze;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    

    @Override
    public String vratiImeTabele() {
        return "dijagnoza";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
            int dijagId = rs.getInt("dijagnozaId");
            String nazivD = rs.getString("naziv");
            String sifraD = rs.getString("sifra");
            
            Dijagnoza dijagnoza = new Dijagnoza(dijagId, nazivD, sifraD);
            lista.add(dijagnoza);
        }
        rs.close();
        return lista;

    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public void postaviId(Integer id) {
        this.dijagnozaId = id;
    }

    @Override
    public String id() {
        return "dijagnozaId="+dijagnozaId;
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "dijagnozaId,naziv,sifra";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return dijagnozaId +",'"+nazivDijagnoze+"','"+sifra+"'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String primarniKljuc() {
        return "dijagnozaId=" + dijagnozaId;
    }

    @Override
    public boolean isAuto() {
        return true;
    }

    @Override
    public String toString() {
        return nazivDijagnoze;
    }
    
}
