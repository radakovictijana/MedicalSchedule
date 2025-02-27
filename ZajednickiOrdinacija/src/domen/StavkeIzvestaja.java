/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class StavkeIzvestaja extends OpstiDomenskiObjekat implements Serializable{
    private int redniBroj;
    private Izvestaj izvestaj;
    private Dijagnoza dijagnoza;
    

    public StavkeIzvestaja() {
    }

    public StavkeIzvestaja(int redniBroj, Izvestaj izvestaj, Dijagnoza dijagnoza) {
        this.redniBroj = redniBroj;
        this.izvestaj = izvestaj;
        this.dijagnoza = dijagnoza;
    }

    

    

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Dijagnoza getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(Dijagnoza dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    

    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }
    

    @Override
    public String vratiImeTabele() {
        return "stavkeizvestaja";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
            int id = rs.getInt("redniBroj");
            
           
            int izvestajId = rs.getInt("izvestajId");
            Date datum = new java.util.Date(rs.getDate("datum").getTime());
            String opis = rs.getString("opis");
            
            int doktorId = rs.getInt("doktorId");
            String imeD = rs.getString("imeDoktora");
            String prezimeD = rs.getString("prezimeDoktora");
            String specijalizacija = rs.getString("specijalizacija");
            String jmbgD =rs.getString("JMBGDoktora");
            String telefonD = rs.getString("telefonDoktora");
            
            Doktor doktor = new Doktor(doktorId, imeD, prezimeD, specijalizacija,jmbgD, telefonD);
            
            int pacijentId = rs.getInt("pacijentId");
            String imepac = rs.getString("imePacijenta");
            String prezimePac = rs.getString("prezimePacijenta");
            String adresa = rs.getString("adresaPacijenta");
            String jmbg = rs.getString("JMBGPacijenta");
            String telefonPac = rs.getString("telefonPacijenta");
           
            Pacijent pacijent = new Pacijent(pacijentId, imepac, prezimePac, adresa,jmbg, telefonPac);
            Izvestaj izvestajS = new Izvestaj(izvestajId, datum, opis, doktor, pacijent, new LinkedList<>());
            int dijagId = rs.getInt("dijagnozaId");
            String nazivD = rs.getString("naziv");
            String sifraD = rs.getString("sifra");
            
            Dijagnoza dijagnozaS = new Dijagnoza(dijagId, nazivD, sifraD);
            StavkeIzvestaja sI = new StavkeIzvestaja(id,izvestajS,dijagnozaS);
            lista.add(sI);
        }
        rs.close();
        return lista;
    
    }

    @Override
    public String vratiUslovZaJoin() {
        return "JOIN izvestaj on izvestaj.izvestajId = stavkeizvestaja.izvestajId "+
                "JOIN dijagnoza on dijagnoza.dijagnozaId = stavkeizvestaja.dijagnozaId "+
                "JOIN doktor on izvestaj.doktorId=doktor.doktorId "+
                "JOIN pacijent on izvestaj.pacijentId=pacijent.pacijentId ";
    }

    @Override
    public void postaviId(Integer id) {
        this.redniBroj = id;
    }

    @Override
    public String id() {
        return "izvestajId"+izvestaj.getIzvestajId()+" AND redniBroj="+redniBroj;
                
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "redniBroj,izvestajId,dijagnozaId";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return redniBroj+","+izvestaj.getIzvestajId()+","+dijagnoza.getDijagnozaId();
                
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String primarniKljuc() {
        return "redniBroj="+redniBroj;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isAuto() {
        return true;
    }

   

    
    
    
    
    
    
}
