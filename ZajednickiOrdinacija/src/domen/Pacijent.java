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
import java.util.Objects;

/**
 *
 * @author WIN 10
 */
public class Pacijent extends OpstiDomenskiObjekat implements Serializable{
    private int pacijentId;
    private String ime;
    private String prezime;
    private String adresa;
    private String jmbg;
    private String telefon;

    public Pacijent() {
    }

    public Pacijent(int pacijentId, String ime, String prezime, String adresa,String jmbg, String telefon) {
        this.pacijentId = pacijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.jmbg = jmbg;
        this.telefon = telefon;
    }

    public int getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(int pacijentId) {
        this.pacijentId = pacijentId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pacijent other = (Pacijent) obj;
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        return true;
    }

   
    

    

    

    @Override
    public String vratiImeTabele() {
        return "pacijent";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
            int pacijentId = rs.getInt("pacijentId");
            String ime = rs.getString("imePacijenta");
            String prezime = rs.getString("prezimePacijenta");
            String adresa = rs.getString("adresaPacijenta");
            String jmbg = rs.getString("JMBGPacijenta");
            String telefon = rs.getString("telefonPacijenta");
            
            Pacijent pacijent = new Pacijent(pacijentId, ime, prezime, adresa,jmbg, telefon);
            lista.add(pacijent);
            
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
        this.pacijentId = id;
    }

    @Override
    public String id() {
        return "pacijentId="+pacijentId;
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        return "CONCAT(imePacijenta,' ',prezimePacijenta) LIKE '%"+parametar+"%'";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "imePacijenta,prezimePacijenta,adresaPacijenta,JMBGPacijenta,telefonPacijenta";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+ime+"','"+prezime+"','"+adresa+"','"+jmbg+"','"+telefon+"'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imePacijenta='"+ime+"',prezimePacijenta='"+prezime+"',adresaPacijenta='"+adresa+"',JMBGPacijenta='"+jmbg+"',telefonPacijenta='"+telefon+"'";
    }

    @Override
    public String primarniKljuc() {
        return "pacijentId="+pacijentId;
    }

    @Override
    public boolean isAuto() {
        return true;
    }
    
    
    
    
    
}
