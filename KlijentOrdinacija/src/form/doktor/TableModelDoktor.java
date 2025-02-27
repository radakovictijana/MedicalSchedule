/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.doktor;

import domen.Doktor;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author WIN 10
 */
public class TableModelDoktor extends AbstractTableModel{
    List<Doktor> lista;
    String [] kolone = new String[]{"Ime i prezime","jmbg","Dr.Specilijalista","telefon"};
    

    public TableModelDoktor(List<Doktor> lista) {
        this.lista = lista;
    }

    

    

    public TableModelDoktor() {
        lista = new LinkedList<>();
                
    }

    
    

    public List<Doktor> getLista() {
        return lista;
    }

    public void setLista(List<Doktor> lista) {
        this.lista = lista;
        if(this.lista == null){
            this.lista = new LinkedList<>();
        }
        fireTableDataChanged();
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
        Doktor doktor = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return doktor;
            case 1: return doktor.getJmbg();
            case 2:return doktor.getSpecijalizaija();
            case 3: return doktor.getTelefon();
            default: return "";
        }
    }

    public Doktor getSelectedRow(int red) {
        return lista.get(red);
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];

    }

    public void add(Doktor doktor)throws Exception {
        if(lista.contains(doktor)){
            throw new Exception("postovi doktor");
        }
        lista.add(doktor);
        fireTableDataChanged();
    }
    public void remove(int red){
        lista.remove(red);
        fireTableDataChanged();
    }

    
    
}
