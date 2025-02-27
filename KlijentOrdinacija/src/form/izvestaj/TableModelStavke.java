/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.izvestaj;

import domen.StavkeIzvestaja;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN 10
 */
public class TableModelStavke extends AbstractTableModel{
    
    List<StavkeIzvestaja> lista;
    String []kolone = new String[]{"Redni broj","Naziv","Sifra"};
    int rb=1;
    public List<StavkeIzvestaja> getLista() {
        return lista;
    }
    

    public TableModelStavke() {
        lista = new LinkedList<>();
    }

    public TableModelStavke(List<StavkeIzvestaja> lista) {
        this.lista = lista;
    }
    
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkeIzvestaja stavkeIzvestaja = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return stavkeIzvestaja.getRedniBroj();
            case 1: return stavkeIzvestaja.getDijagnoza().getNazivDijagnoze();
            case 2: return stavkeIzvestaja.getDijagnoza().getSifra();
            default: return "";
            
        }
    }

    @Override
    public String getColumnName(int column) {
        return  kolone[column];
    }
    public void dodaj(StavkeIzvestaja stavkeIzvestaja) throws Exception{
        if(lista.contains(stavkeIzvestaja)){
            throw new Exception("Vec postoji u tabeli");
        }
        stavkeIzvestaja.setRedniBroj(rb++);
        lista.add(stavkeIzvestaja);
        fireTableDataChanged();
        
    }
    public void obrisi(int red){
        lista.remove(red);
        rb = 1;
        for (StavkeIzvestaja st: lista){
            st.setRedniBroj(rb++);
        }
        fireTableDataChanged();
    }
}
