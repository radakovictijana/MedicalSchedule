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
public class Doktor extends OpstiDomenskiObjekat implements Serializable{
    private int doktorId;
    private String ime;
    private String prezime;
    private String jmbg;
    private String specijalizaija;
    private String telefon;

    public Doktor() {
    }

    public Doktor(int doktorId, String ime, String prezime, String specijalizaija,String jmbg, String telefon) {
        this.doktorId = doktorId;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizaija = specijalizaija;
        this.jmbg= jmbg;
        this.telefon = telefon;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(int doktorId) {
        this.doktorId = doktorId;
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

    public String getSpecijalizaija() {
        return specijalizaija;
    }

    public void setSpecijalizaija(String specijalizaija) {
        this.specijalizaija = specijalizaija;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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
        final Doktor other = (Doktor) obj;
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        return true;
    }



    @Override
    public String vratiImeTabele() {
        return "doktor";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
            int doktorId = rs.getInt("doktorId");
            String ime = rs.getString("imeDoktora");
            String prezime = rs.getString("prezimeDoktora");
            String specijalizacija = rs.getString("specijalizacija");
            String jmbg = rs.getString("JMBGDoktora");
            String telefon = rs.getString("telefonDoktora");
            
            Doktor doktor = new Doktor(doktorId, ime, prezime, specijalizacija,jmbg, telefon);
            lista.add(doktor);
        }
        rs.close();
        return lista;
    }

    @Override
    public void postaviId(Integer id) {
        this.doktorId = id;
    }


   

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "imeDoktora,prezimeDoktora,JMBGDoktora,specijalizacija,telefonDoktora";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+ime+"','"+prezime+"','"+jmbg+"','"+specijalizaija+"','"+telefon+"'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imeDoktora='"+ime+"',prezimeDoktora='"+prezime+"',JMBGDoktora='"+jmbg+"',specijalizacija ='"+specijalizaija+"',telefonDoktora='"+telefon+"'";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String id() {
        return "doktorId="+ doktorId;
    }

    @Override
    public String primarniKljuc() {
        return "doktorId="+doktorId;
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        return "CONCAT(imeDoktora,' ',prezimeDoktora) LIKE '%"+parametar+"%'";
    }

    @Override
    public boolean isAuto() {
        return true;
    }
   
    
           
    
}
