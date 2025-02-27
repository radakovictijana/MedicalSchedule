/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author WIN 10
 */
public class DBBroker {
    private static DBBroker instance;
    private Connection konekcija;

    public static DBBroker getInstance() throws Exception {
        if(instance == null){
            instance = new DBBroker();
        }
        return instance;
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public DBBroker() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("dbconfig.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String pass = properties.getProperty("pass");
        konekcija = DriverManager.getConnection(url,username,pass);
        konekcija.setAutoCommit(false);
        
    }

    public DBBroker(Connection konekcija) {
        this.konekcija = konekcija;
    }
    public List<OpstiDomenskiObjekat> getAll(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM " + odo.vratiImeTabele()+ " "+odo.vratiUslovZaJoin();
        ResultSet rs = konekcija.createStatement().executeQuery(upit);
        return odo.vratiListu(rs);
    }
    public void insert(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "INSERT INTO " + odo.vratiImeTabele() + " (" + odo.vratiNaziveKolonaZaInsert() + ") VALUES(" + odo.vratiVrednostiZaInsert() + ")";
        PreparedStatement ps;
        if(odo.isAuto()){
            ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        }else{
            ps = konekcija.prepareStatement(upit);
        }
        ps.execute();
        if(odo.isAuto()){
             ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                odo.postaviId(rs.getInt(1));
            }
        }       
        
    }
    
    public void update(OpstiDomenskiObjekat odo) throws SQLException {
        String upit ="UPDATE " + odo.vratiImeTabele() + " SET " + odo.vratiVrednostiZaUpdate()+" WHERE " + odo.id();
        konekcija.createStatement().executeUpdate(upit);
    }
    
    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiImeTabele() + " WHERE " + odo.primarniKljuc();
        konekcija.createStatement().execute(upit);
    }
    
    public List<OpstiDomenskiObjekat> search(OpstiDomenskiObjekat odo,String parametar)throws SQLException{
        String upit = "SELECT * FROM "+ odo.vratiImeTabele() +" "+odo.vratiUslovZaJoin() +"WHERE " + odo.vratiUslovZaPretragu(parametar);
        ResultSet rs = konekcija.createStatement().executeQuery(upit);
        return odo.vratiListu(rs);
        
    }
    
}
