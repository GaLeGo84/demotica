/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class Divisions extends javax.swing.JFrame {

    /**
     * Creates new form Divisions
     */
    public Divisions() {
        initComponents();
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
        tblDivisions = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDoors = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfWindows = new javax.swing.JTextField();
        comboFloor = new javax.swing.JComboBox();
        checkExt = new javax.swing.JCheckBox();
        radioEnt = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tfLights = new javax.swing.JTextField();
        addB = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lMessage = new javax.swing.JLabel();
        updateB = new javax.swing.JButton();
        removeB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDivisions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Piso", "Nº de portas", "Porta p/ o exterior", "Porta de entrada", "Nº de janelas", "Nº de luzes"
            }
        ));
        tblDivisions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDivisionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDivisions);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Piso:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("DIVISÕES");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Nº de portas interiores:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Nº de janelas:");

        comboFloor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        comboFloor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "r/c", "1º", "2º" }));
        comboFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFloorActionPerformed(evt);
            }
        });

        checkExt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        checkExt.setText("Porta p/ o exterior");

        radioEnt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        radioEnt.setText("Porta de entrada");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Nº de luzes:");

        addB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addB.setText("Adicionar");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setText("Concluido");

        lMessage.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lMessage.setForeground(new java.awt.Color(255, 0, 51));
        lMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        updateB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        updateB.setText("Atualizar");
        updateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBActionPerformed(evt);
            }
        });

        removeB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeB.setText("Remover");
        removeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel5))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfDoors)
                            .addComponent(tfWindows)
                            .addComponent(tfLights))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkExt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioEnt)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeB)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDoors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkExt)
                    .addComponent(radioEnt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfWindows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfLights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addB)
                    .addComponent(updateB)
                    .addComponent(removeB))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFloorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFloorActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        lMessage.setText("");
        DefaultTableModel model=(DefaultTableModel)tblDivisions.getModel();
        if(!tfName.getText().trim().equals("")){
        model.addRow(new Object[]{tfName.getText(), comboFloor.getSelectedItem().toString(), tfDoors.getText(), tfWindows.getText(), tfLights.getText()});
        
        }else{
            lMessage.setText("O nome da divisão não deve ser deixado em branco!");
        }
    
    }//GEN-LAST:event_addBActionPerformed

    private void updateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBActionPerformed
        DefaultTableModel model=(DefaultTableModel)tblDivisions.getModel();
        if(tblDivisions.getSelectedRow()==-1){
            if(tblDivisions.getRowCount()==0){
                lMessage.setText("A tabela está vazia!");
            }else{
                lMessage.setText("Deve selecionar uma divisão!");
            }
        }else{
            model.setValueAt(tfName.getText(), tblDivisions.getSelectedRow(), 0);
            model.setValueAt(comboFloor.getSelectedItem().toString(), tblDivisions.getSelectedRow(), 1);
            model.setValueAt(tfDoors.getText(), tblDivisions.getSelectedRow(), 2);
            model.setValueAt(tfWindows.getText(), tblDivisions.getSelectedRow(), 3);
            model.setValueAt(tfLights.getText(), tblDivisions.getSelectedRow(), 4);
        }
    }//GEN-LAST:event_updateBActionPerformed

    private void removeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBActionPerformed
        DefaultTableModel model=(DefaultTableModel)tblDivisions.getModel();
        if(tblDivisions.getSelectedRow()==-1){
            if(tblDivisions.getRowCount()==0){
                lMessage.setText("A tabela está vazia!");
            }else{
                lMessage.setText("Deve selecionar uma divisão!");
            }
        }else{
            model.removeRow(tblDivisions.getSelectedRow());
        }
    }//GEN-LAST:event_removeBActionPerformed

    private void tblDivisionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDivisionsMouseClicked
        DefaultTableModel model=(DefaultTableModel)tblDivisions.getModel();
        tfName.setText(model.getValueAt(tblDivisions.getSelectedRow(), 0).toString());
        comboFloor.setSelectedItem(model.getValueAt(tblDivisions.getSelectedRow(), 1).toString());
        tfDoors.setText(model.getValueAt(tblDivisions.getSelectedRow(), 2).toString());
        tfWindows.setText(model.getValueAt(tblDivisions.getSelectedRow(), 3).toString());
        tfLights.setText(model.getValueAt(tblDivisions.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tblDivisionsMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Divisions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JCheckBox checkExt;
    private javax.swing.JComboBox comboFloor;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMessage;
    private javax.swing.JRadioButton radioEnt;
    private javax.swing.JButton removeB;
    private javax.swing.JTable tblDivisions;
    private javax.swing.JTextField tfDoors;
    private javax.swing.JTextField tfLights;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfWindows;
    private javax.swing.JButton updateB;
    // End of variables declaration//GEN-END:variables
}
