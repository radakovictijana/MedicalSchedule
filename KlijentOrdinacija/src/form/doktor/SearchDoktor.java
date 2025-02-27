/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.doktor;

import controller.KlijentKontroler;
import domen.Doktor;
import domen.Termin;
import form.FormEnum;
import form.termin.NewTermin;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN 10
 */
public class SearchDoktor extends javax.swing.JDialog {

    /**
     * Creates new form SearchDoktor
     */
    private TableModelDoktor tableModelDoktor;
    public SearchDoktor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoktor = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        txtPretraga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnIzadji = new javax.swing.JButton();
        btnZakazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDoktor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDoktor);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        jLabel1.setText("Pretraga");

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnZakazi.setText("Zakazi za doktora");
        btnZakazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnZakazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzadji))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPretraga)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeni)
                        .addGap(32, 32, 32)
                        .addComponent(btnIzbrisi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnIzbrisi)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzadji)
                    .addComponent(btnZakazi))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        try{
            String pretraga = txtPretraga.getText().trim();
            List<Doktor> lista;
            if(pretraga.isEmpty()){
                lista = KlijentKontroler.getInstance().getAllDoktor();
            }else{
                lista = KlijentKontroler.getInstance().searchDoktor(pretraga);
            }
            tableModelDoktor.setLista(lista);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        try{
            int red = tblDoktor.getSelectedRow();
            if(red>=0){
                Doktor doktor = tableModelDoktor.getSelectedRow(red);
                int opcija = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da zelite da obrisete"+doktor+"?");
                if(opcija ==JOptionPane.YES_OPTION){
                    
                     KlijentKontroler.getInstance().deleteDoktor(doktor);
                    JOptionPane.showMessageDialog(this, "Uspesno ste obrisali doktora");
                    this.dispose();
                }
               
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        try{
            int red = tblDoktor.getSelectedRow();
            if(red>=0){
                Doktor doktor = tableModelDoktor.getSelectedRow(red);
                new NewDoktor((Frame)this.getParent(), rootPaneCheckingEnabled, FormEnum.IZMENA, doktor).setVisible(true);
                this.dispose();
            }
                    
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziActionPerformed
        int red = tblDoktor.getSelectedRow();
        if(red >-1){
            Doktor doktor = tableModelDoktor.getSelectedRow(red);
            new NewTermin((Frame)this.getParent(), rootPaneCheckingEnabled, new Termin(),doktor).setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_btnZakaziActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnZakazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoktor;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void setModel() {
        try{
            List<Doktor> lista = KlijentKontroler.getInstance().getAllDoktor();
            tableModelDoktor = new TableModelDoktor(lista);
            tblDoktor.setModel(tableModelDoktor);
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
