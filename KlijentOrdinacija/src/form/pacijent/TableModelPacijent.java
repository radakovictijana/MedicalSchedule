/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.pacijent;

import domen.Pacijent;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class TableModelPacijent extends AbstractTableModel{
    
    String [] kolone = new String[]{"Ime i Prezime","JMBG","Adresa","Telefon"};
    List<Pacijent> lista;

    public List<Pacijent> getLista() {
        return lista;
    }

    public void setLista(List<Pacijent> lista) {
        this.lista = lista;
        if (this.lista == null) {
            this.lista= new LinkedList<>();
        }
        fireTableDataChanged();
    }
    

    public TableModelPacijent() {
    }

    public TableModelPacijent(List<Pacijent> lista) {
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
        Pacijent pacijent = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return pacijent;
            case 1: return pacijent.getJmbg();
            case 2: return pacijent.getAdresa();
            case 3: return pacijent.getTelefon();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
   public Pacijent getSelectedRow(int row){
       return lista.get(row);
   }

    
   
   
}
