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
public class Tehnicar extends OpstiDomenskiObjekat implements Serializable{
    private int tehnicarId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Tehnicar() {
    }

    public Tehnicar(int tehnicarId, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.tehnicarId = tehnicarId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getTehnicarId() {
        return tehnicarId;
    }

    public void setTehnicarId(int tehnicarId) {
        this.tehnicarId = tehnicarId;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ime+" "+ prezime;
        
        
        
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
        final Tehnicar other = (Tehnicar) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {
        return "tehnicar";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista= new LinkedList<>();
        while(rs.next()){
            int tehnicarId = rs.getInt("tehnicarId");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String korisnickoIme = rs.getString("korisnickoIme");
            String lozinka = rs.getString("lozinka");
            
            Tehnicar tehnicar= new Tehnicar(tehnicarId, ime, prezime, korisnickoIme, lozinka);
            lista.add(tehnicar);
            
        }
        rs.close();
        return lista;
    }

    @Override
    public void postaviId(Integer id) {
        this.tehnicarId = id;
    }

   

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "tehnicarId,ime,prezime,korisnickoIme,lozinka";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String id() {
        return "tehnicarId="+tehnicarId;
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String primarniKljuc() {
        return "tehnicarId="+tehnicarId;
    }

    @Override
    public boolean isAuto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
