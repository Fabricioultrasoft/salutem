/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroPaciente.java
 *
 * Created on 02/05/2012, 13:02:38
 */
package salutem.Telas;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import salutem.Beans.EspecialidadeBean;
import salutem.Beans.PacienteBean;
import salutem.DAO.pacienteDAO;
import salutem.Utils.Msg;
import salutem.Utils.Params;
import salutem.Utils.Utils;

/**
 *
 * @author Tironi
 */
public class TelaCadastroPaciente extends JDialog {

    private pacienteDAO pacienteDao = new pacienteDAO();
    private PacienteBean pacienteBean = new PacienteBean();
    private boolean inserir;
    private Integer idPaciente;
    private TelaBuscaPaciente telaBusca;

    /** Creates new form TelaCadastroPaciente */
    public TelaCadastroPaciente() {
        initComponents();
        this.setModal(true);
          pularCampo();
       



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNomeMae = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dtDataNascimento = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txNumeroSUS = new javax.swing.JTextField();
        txCpf = new javax.swing.JFormattedTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txRua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txComplemento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        cbCidade = new javax.swing.JComboBox();
        txNumero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txTelefone = new javax.swing.JTextField();
        txCelular = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnGravar1 = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Paciente"));
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Nome");

        jLabel2.setText("RG");

        jLabel3.setText("Data de Nascimento");

        jLabel4.setText("Nome da Mãe");

        jLabel5.setText("Nº do Cartão SUS");

        jLabel12.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....", "M", "F" }));

        jLabel15.setText("Cpf");

        try {
            txCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE))
                                    .addComponent(txRg, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(102, 102, 102))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txNumeroSUS, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNumeroSUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jLabel6.setText("Rua");

        jLabel7.setText("Numero");

        jLabel8.setText("Complemento");

        jLabel9.setText("Bairro");

        jLabel13.setText("Estado");

        jLabel14.setText("Cidade");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....", "MASCULINO", "FEMININO" }));

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....", "MASCULINO", "FEMININO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txRua, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel14)
                                .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel2);

        jLabel10.setText("Telefone");

        jLabel11.setText("Celular");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefone", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-cancelar.png"))); // NOI18N
        btnGravar1.setText("Cancelar");
        btnGravar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravar1ActionPerformed(evt);
            }
        });

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-salvar.png"))); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnGravar1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
    
    salvar();
    

}//GEN-LAST:event_btnGravarActionPerformed

private void btnGravar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravar1ActionPerformed
    cancelar();
}//GEN-LAST:event_btnGravar1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastroPaciente().setVisible(true);
            }
        });
    }
   
    public PacienteBean selecionarItemCombo() {
        if (cbSexo.getSelectedItem().equals("MASCULINO")) {
            pacienteBean.setSexo("M");
        } else if (cbSexo.getSelectedItem().equals("FEMININO")) {
            pacienteBean.setSexo("F");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o Sexo.");
        }
       
       return pacienteBean;
    }
    public void pularCampo(){
       
         HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));   
         conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));  
         this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);  
    }
    
    private void destacarCampo(Component c, boolean b) {
        if (b) {
            c.setBackground(Params.COR_CAMPO_VAZIO);
        } else {
            c.setBackground(Params.COR_CAMPO_NORMAL);
        }
    }
    public void perdeFoco(){
       
      
        //this.txCpf.lostFocus(null, this);
        //if (this.txCpf.getText().length() < 15){
          //  JOptionPane.showMessageDialog(null, "CPF DEVE CONTER TODOS OS DIGITOS.");
        //}
        
    }

    private boolean verificarCampos() {
        boolean aux = false;
        String msg = "Preencha corretamente os campos. \n";
        
        if (this.txCpf.getText().length() < 15){
            JOptionPane.showMessageDialog(null, "CPF DEVE CONTER TODOS OS DIGITOS.");
        }
        
        if (this.txNome.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txNome, aux);

        }
        
        
        
         if (this.txCpf.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txCpf, aux);

        }

        if (this.txBairro.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txBairro, aux);
        }
        if (this.txCelular.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txCelular, aux);
        }

        if (this.txTelefone.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txTelefone, aux);
        }

        if (this.txComplemento.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txComplemento, aux);
        }

        if (this.txNomeMae.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txNomeMae, aux);

        }

        if (this.txNumero.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txNumero, aux);
        }

        if (this.txNumeroSUS.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txNumeroSUS, aux);
        }

        if (this.txRg.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txRg, aux);
        }

        if (this.txRua.getText().isEmpty()) {
            aux = true;

            this.destacarCampo(this.txRua, aux);
        }
        
        

        if (aux) {
            Msg.alerta(this, msg);
        }
        return aux;
    }

   
            
    
    protected void preencherCampos(int id) {
        try {
            
            
            
            PacienteBean paciente = pacienteDao.getPaciente(id);
            
            this.idPaciente = paciente.getIdPaciente();
            this.txNome.setText(paciente.getNome().trim().toUpperCase());
            this.txBairro.setText(paciente.getBairro().trim().toUpperCase());
            this.txCelular.setText(paciente.getCelular());
            this.txComplemento.setText(paciente.getComplemento().trim().toUpperCase());
            this.txCpf.setText(paciente.getCpfCnpj());
            this.txNomeMae.setText(paciente.getNomeMae().trim().toUpperCase());
            this.txNumero.setText(String.valueOf(paciente.getNumero()));
            this.txNumeroSUS.setText(paciente.getCartaoSus());
            this.txRg.setText(paciente.getRgie());
            this.txRua.setText(paciente.getRua().trim().toUpperCase());
            this.txTelefone.setText(paciente.getTelefone());
            this.cbSexo.setSelectedItem(paciente.getSexo());
            
           
            
        } catch (SQLException ex) {
            Msg.erro(this, "Erro ao preencher campos. \n" + ex.getMessage());
        }
    }
    
    

    protected boolean isInserir() {
        return inserir;
    }

    protected void setInserir(boolean inserir) {
        this.inserir = inserir;
        this.idPaciente = null;
    }

    private void cancelar() {
        this.setVisible(false);
        this.dispose();
    }

    private void salvar() {
        if (this.verificarCampos()) {
            return;
        }
        try {
            if (this.isInserir()) {
                
                        
                PacienteBean paciente = new PacienteBean();
                paciente.setNome(this.txNome.getText().trim().toUpperCase());
                paciente.setBairro(this.txBairro.getText().trim().toUpperCase());
                paciente.setCartaoSus(this.txNumeroSUS.getText().trim().toUpperCase());
                paciente.setCelular(this.txCelular.getText().trim().toUpperCase());
                paciente.setData(dtDataNascimento.getDate());
                paciente.setComplemento(this.txComplemento.getText().trim().toUpperCase());
                paciente.setCpfCnpj(this.txCpf.getText().trim().toUpperCase());
                paciente.setNumero(Integer.parseInt(this.txNumero.getText()));
                paciente.setNomeMae(this.txNomeMae.getText().trim().toUpperCase());
                paciente.setRgie(this.txRg.getText().trim().toUpperCase());
                paciente.setTelefone(this.txTelefone.getText().trim().toUpperCase());
                paciente.setRua(this.txRua.getText().trim().toUpperCase());
                String sexo;
                sexo = (String) cbSexo.getSelectedItem();
                
                paciente.setSexo(sexo);
               
                this.pacienteDao.inserir(paciente);
                Msg.informacao(this, "Salvo com sucesso.");
                telaBusca = new TelaBuscaPaciente(null, inserir);
                this.telaBusca.atualizarTabela();
                this.cancelar();
            } else {
                PacienteBean paciente = new PacienteBean();
                paciente.setIdPaciente(this.idPaciente);
                paciente.setNome(this.txNome.getText().trim().toUpperCase());
                this.pacienteDao.alterar(paciente);
                Msg.informacao(this, "Alterado Com Sucesso.");
                telaBusca = new TelaBuscaPaciente(null, inserir);
                this.telaBusca.atualizarTabela();
                this.cancelar();
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
            Msg.erro(this, "Erro ao salvar. \n" + ex.getMessage());
        }
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnGravar1;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbSexo;
    private org.jdesktop.swingx.JXDatePicker dtDataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txCelular;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JFormattedTextField txCpf;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNomeMae;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txNumeroSUS;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txRua;
    private javax.swing.JTextField txTelefone;
    // End of variables declaration//GEN-END:variables
}
