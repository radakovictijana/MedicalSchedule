/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import konstante.StatusOdgovora;

/**
 *
 * @author WIN 10
 */
public class ServerskiOdgovor implements Serializable{
    private Object podatak;
    private Exception greska;
    private StatusOdgovora status;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object podatak, Exception greska, StatusOdgovora status) {
        this.podatak = podatak;
        this.greska = greska;
        this.status = status;
    }

    public Object getPodatak() {
        return podatak;
    }

    public void setPodatak(Object podatak) {
        this.podatak = podatak;
    }

    public Exception getGreska() {
        return greska;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }
    
    
    
}
