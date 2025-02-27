/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.termin;

import domen.Termin;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN 10
 */
public class TableModelTermin extends AbstractTableModel{

    String [] kolone = new String[]{"Pacijent","Doktor","Intervencija","Datum"};
    List<Termin> lista;

    public List<Termin> getLista() {
        return lista;
    }

    public TableModelTermin() {
        lista = new LinkedList<>();
    }

    
    public TableModelTermin(List<Termin> lista) {
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
        Termin termin = lista.get(rowIndex);

        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        switch(columnIndex){
            case 0: return termin.getPacijent();
            case 1: return termin.getDoktor();
            case 2: return termin.getIntervencija();
            case 3: return sdf.format(termin.getDatum());
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public Termin getSelectedRow(int red){
        return lista.get(red);
    }

    public void setLista(List<Termin> lista) {
        this.lista = lista;
        if(this.lista == null){
            this.lista = new LinkedList<>();
        }
        fireTableDataChanged();
    }
    public void dodaj(Termin termin){
        lista.add(termin);
        fireTableDataChanged();
    }
    
}
