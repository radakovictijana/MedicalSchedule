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

/**
 *
 * @author WIN 10
 */
public class Izvestaj extends OpstiDomenskiObjekat implements Serializable{
    private int izvestajId;
    private Date datum;
    private String opis;
    private Doktor doktor;
    private Pacijent pacijent;
    private List<StavkeIzvestaja> stavkaIzvestaje;

    public Izvestaj() {
    }

    public Izvestaj(int izvestajId, Date datum, String opis, Doktor doktor, Pacijent pacijent, List<StavkeIzvestaja> stavkaIzvestaje) {
        this.izvestajId = izvestajId;
        this.datum = datum;
        this.opis = opis;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.stavkaIzvestaje = stavkaIzvestaje;
    }

    public int getIzvestajId() {
        return izvestajId;
    }

    public void setIzvestajId(int izvestajId) {
        this.izvestajId = izvestajId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public List<StavkeIzvestaja> getStavkaIzvestaje() {
        return stavkaIzvestaje;
    }

    public void setStavkaIzvestaje(List<StavkeIzvestaja> stavkaIzvestaje) {
        this.stavkaIzvestaje = stavkaIzvestaje;
    }

    

    @Override
    public String vratiImeTabele() {
        return "izvestaj";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        while(rs.next()){
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
            
            Izvestaj izvestaj = new Izvestaj(izvestajId, datum, opis, doktor, pacijent, null);

            lista.add(izvestaj);
           
        }
        rs.close();
        return lista;
    }

    @Override
    public String vratiUslovZaJoin() {
        return "JOIN doktor on izvestaj.doktorId=doktor.doktorId "+
                "JOIN pacijent on izvestaj.pacijentId=pacijent.pacijentId ";
                
                
    }

    @Override
    public void postaviId(Integer id) {
        this.izvestajId = id;
    }

    @Override
    public String id() {
        return "izvestajId="+izvestajId;
    }

    @Override
    public String vratiUslovZaPretragu(String parametar) {
        return "CONCAT(doktor.imeDoktora,' ',doktor,prezimeDoktora) like '%"+parametar+"' or CONCAT(pacijent.imePacijenta,' ',pacijent.prezimePacijenta) like '%"+parametar+"'";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "datum,opis,doktorId,pacijentId";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "'"+sdf.format(datum)+"','"+opis+"',"+doktor.getDoktorId()+","+pacijent.getPacijentId();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "datum='"+sdf.format(datum)+"',opis='"+opis+"',doktorId="+doktor.getDoktorId()+",pacijentId='"+pacijent.getPacijentId();
    }

    @Override
    public String primarniKljuc() {
        return "izvestajId="+izvestajId;
    }

    @Override
    public boolean isAuto() {
        return true;
    }
    
    
    
}
