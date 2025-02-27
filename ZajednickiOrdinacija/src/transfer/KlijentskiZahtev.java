/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author WIN 10
 */
public class KlijentskiZahtev implements Serializable{
   
    private int operacija;
    private Object podatak;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object podatak) {
        this.operacija = operacija;
        this.podatak = podatak;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getPodatak() {
        return podatak;
    }

    public void setPodatak(Object podatak) {
        this.podatak = podatak;
    }
    
    
    
}
