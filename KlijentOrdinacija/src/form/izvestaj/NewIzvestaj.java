/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.izvestaj;

import controller.KlijentKontroler;
import domen.Dijagnoza;
import domen.StavkeIzvestaja;
import domen.Doktor;
import domen.Izvestaj;
import domen.Pacijent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN 10
 */
public class NewIzvestaj extends javax.swing.JDialog {

    /**
     * Creates new form NewIzvestaj
     */
    private Izvestaj izvestaj;
    private TableModelStavke tableModelStavkeIzvestaja;
    public NewIzvestaj(java.awt.Frame parent, boolean modal,Izvestaj izvestaj) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.izvestaj = izvestaj;
        setTableModel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbDoktori = new javax.swing.JComboBox<>();
        txtOpis = new javax.swing.JTextField();
        cmbPacijent = new javax.swing.JComboBox<>();
        txtDatum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnIzbaci = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        cmbDijagnoza = new javax.swing.JComboBox<>();
        btnizadji = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum");

        jLabel2.setText("Pacijent");

        jLabel3.setText("Dr. specijalista");

        jLabel4.setText("Opis");

        cmbDoktori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDoktoriActionPerformed(evt);
            }
        });

        txtOpis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpisActionPerformed(evt);
            }
        });

        jButton1.setText("Sacuvaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("U formatu dd.MM.yyyy.");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzbaci.setText("Izbrisi");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        jLabel7.setText("Dijagnoza");

        jLabel5.setText("Unos  stavke izvestaja");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnDodaj)
                                .addGap(157, 157, 157)
                                .addComponent(btnIzbaci))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cmbDijagnoza, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDijagnoza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzbaci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnizadji.setText("Izadji");
        btnizadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnizadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnizadji)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator2))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPacijent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtOpis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbDoktori, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cmbPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDoktori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnizadji))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDoktoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDoktoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDoktoriActionPerformed

    private void txtOpisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOpisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String datumIzvestaja = txtDatum.getText();
            if(datumIzvestaja.isEmpty()){
                throw new Exception("Niste dobro uneli datum");
                
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            Date datum = sdf.parse(datumIzvestaja);
            String opis = txtOpis.getText();
            
            if(opis.isEmpty()){
                throw new Exception("Niste uneli opis");
                
                
            }
            Pacijent pacijent = (Pacijent) cmbPacijent.getSelectedItem();
            Doktor doktor = (Doktor) cmbDoktori.getSelectedItem();
            
            List<StavkeIzvestaja> stavkeIzvestajaLista = tableModelStavkeIzvestaja.getLista();
            
            izvestaj.setDoktor(doktor);
            izvestaj.setDatum(datum);
            izvestaj.setOpis(opis);
            izvestaj.setPacijent(pacijent);
            izvestaj.setStavkaIzvestaje(stavkeIzvestajaLista);
            for(StavkeIzvestaja st: stavkeIzvestajaLista){
                
                
            }
            
            KlijentKontroler.getInstance().addIzvestaj(izvestaj);
            JOptionPane.showMessageDialog(this, "Uspesno ste uneli izvestaj");
            this.dispose();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        try{
            int red = tblStavke.getSelectedRow();
            if(red >= 0){
               tableModelStavkeIzvestaja.obrisi(red);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
                
    }//GEN-LAST:event_btnIzbaciActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try{
            Dijagnoza dijagnoza = (Dijagnoza) cmbDijagnoza.getSelectedItem();
            
             
            StavkeIzvestaja st= new StavkeIzvestaja(-1, izvestaj, dijagnoza);
                    
            tableModelStavkeIzvestaja.dodaj(st);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnizadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnizadjiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnizadjiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnizadji;
    private javax.swing.JComboBox<Object> cmbDijagnoza;
    private javax.swing.JComboBox<Object> cmbDoktori;
    private javax.swing.JComboBox<Object> cmbPacijent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtOpis;
    // End of variables declaration//GEN-END:variables

    private void setTableModel() {
        try{
            tableModelStavkeIzvestaja = new TableModelStavke();
            tblStavke.setModel(tableModelStavkeIzvestaja);
                    
            List<Doktor> listaDoktora = KlijentKontroler.getInstance().getAllDoktor();
            List<Pacijent> listaPacijenata = KlijentKontroler.getInstance().getAllPacijenti();
            List<Dijagnoza> listaDijagnoza = KlijentKontroler.getInstance().getAllDijagnoza();
            for(Dijagnoza d: listaDijagnoza){
                cmbDijagnoza.addItem(d);
            }
            for(Doktor d: listaDoktora){
                cmbDoktori.addItem(d);
            
            }
            for(Pacijent p: listaPacijenata){
                cmbPacijent.addItem(p);
            }
        
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
