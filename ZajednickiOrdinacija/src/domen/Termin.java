/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date.*;

/**
 *
 * @author WIN 10
 */
public class Termin extends OpstiDomenskiObjekat implements Serializable{
    private int terminId;
    private Date datum;
    private String intervencija;
    private Doktor doktor;
    private Pacijent pacijent;
    private Tehnicar tehnicar;

    public Termin() {
    }

    public Termin(int terminId, Date datum, String intervencija, Doktor doktor, Pacijent pacijent, Tehnicar tehnicar) {
        this.terminId = terminId;
        this.datum = datum;
        this.intervencija = intervencija;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.tehnicar = tehnicar;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

   

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getIntervencija() {
        return intervencija;
    }

    public void setIntervencija(String intervencija) {
        this.intervencija = intervencija;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    

    public Tehnicar getTehnicar() {
        return tehnicar;
    }

    public void setTehnicar(Tehnicar tehnicar) {
        this.tehnicar = tehnicar;
    }

    
    
    @Override
    public String vratiImeTabele() {
        return "termin";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
            
            
            int pacijentId = rs.getInt("pacijentId");
            String imePacije = rs.getString("imePacijenta");
            String prezimePac = rs.getString("prezimePacijenta");
            String adresa = rs.getString("adresaPacijenta");
            String jmbg = rs.getString("JMBGPacijenta");
            String telefonPac = rs.getString("telefonPacijenta");
           
            Pacijent pacijent = new Pacijent(pacijentId, imePacije, prezimePac, adresa,jmbg, telefonPac);

            
            int tehnicarId = rs.getInt("tehnicarId");
            String imeTeh = rs.getString("ime");
            String prezimeTeh = rs.getString("prezime");
            String korisnickoIme = rs.getString("korisnickoIme");
            String lozinka = rs.getString("lozinka");
            
            Tehnicar tehnicar= new Tehnicar(tehnicarId, imeTeh, prezimeTeh, korisnickoIme, lozinka);
            
            int terminId = rs.getInt("terminId");
            Date datum = new java.util.Date(rs.getDate("datum").getTime());
            String intervencija = rs.getString("intervencija");
            
            int doktorId = rs.getInt("doktorId");
            String ime = rs.getString("imeDoktora");
            String prezime = rs.getString("prezimeDoktora");
            String specijalizacija = rs.getString("specijalizacija");
            String jmbgdok = rs.getString("JMBGDoktora");
            String telefon = rs.getString("telefonDoktora");
            
            Doktor doktor = new Doktor(doktorId, ime, prezime, specijalizacija,jmbgdok, telefon);
            Termin termin = new Termin(terminId, datum, intervencija, doktor, pacijent, tehnicar);
            
           

           lista.add(termin);
            
            
            
        }
        rs.close();
        return lista;
    }

    @Override
    public void postaviId(Integer id) {

        this.terminId = id;
    }

   
    @Override
    public String vratiUslovZaPretragu(String parametar) {
        return "CONCAT(pacijent.imePacijenta,' ',pacijent.prezimePacijenta) like '%"+parametar+"%' or CONCAT(doktor.imeDoktora,' ',doktor.prezimeDoktora) like '%"+parametar+"%'";
        
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "datum,intervencija,doktorId,pacijentId,tehnicarId";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "'"+sdf.format(new java.sql.Date((datum).getTime()))+"','"+intervencija+"',"+doktor.getDoktorId()+","+pacijent.getPacijentId()+","+tehnicar.getTehnicarId();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "datum='"+sdf.format(datum)+"',intervencija='"+intervencija+"',doktorId="+doktor.getDoktorId()+",pacijentId="+pacijent.getPacijentId()+",tehnicarId="+tehnicar.getTehnicarId();

    }

    @Override
    public String vratiUslovZaJoin() {
        return "JOIN pacijent on termin.pacijentId=pacijent.pacijentId "+
                "JOIN tehnicar on termin.tehnicarId = tehnicar.tehnicarId "+
                "JOIN doktor on termin.doktorId = doktor.doktorId ";
                

    }

    @Override
    public String primarniKljuc() {
        return "terminId="+terminId;
    }

    @Override
    public String id() {
        return "terminId="+terminId;

    }

    @Override
    public String toString() {
        return datum+"";
    }

    @Override
    public boolean isAuto() {
        return true;
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
        final Termin other = (Termin) obj;
        if (this.terminId != other.terminId) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}
