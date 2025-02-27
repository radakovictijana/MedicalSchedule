/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.izvestaj;

import domen.Izvestaj;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN 10
 */
public class TableModelIzvestaji extends AbstractTableModel{
    String[] kolone = new String[]{"Doktor","Pacijent","Datum","Opis"};
    List<Izvestaj> lista;

    public TableModelIzvestaji() {
        lista = new LinkedList<>();
    }

    public TableModelIzvestaji(List<Izvestaj> lista) {
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
        Izvestaj i = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return i.getDoktor();
            case 1: return i.getPacijent();
            case 2: return i.getDatum();
            case 3: return i.getOpis();
            default: return "";
        }
    }

    Izvestaj getSelectedIzvestaj(int red) {
        Izvestaj izvestaj = lista.get(red);
        return izvestaj;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
