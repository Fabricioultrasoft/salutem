/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaEncaminhamento.java
 *
 * Created on 17/05/2012, 09:23:27
 */
package salutem.Telas;

import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import salutem.Beans.EncaminhamentoBean;
import salutem.Beans.EspecialidadeBean;
import salutem.Beans.PacienteBean;
import salutem.DAO.EncaminhamentoDAO;
import salutem.DAO.EspecialidadeDAO;
import salutem.DAO.pacienteDAO;
import salutem.Utils.Msg;
import salutem.Utils.Params;

/**
 *
 * @author Tironi
 */
public class TelaEncaminhamento extends javax.swing.JDialog {
private List<EspecialidadeBean> esps;
private EspecialidadeDAO especialidadeDao;
private pacienteDAO pacientedao;
private int idPac;
private Integer idPaciente;
private TelaPacientePesquisa telaBusca;
private boolean inserir;
private String nomeEspecialidade;
private String nomePaciente;

    
    /** Creates new form TelaEncaminhamento */
    public TelaEncaminhamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarCbEspecialidade();
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
        dtData = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        cbEspecialidade = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txDescricao = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnEncaminhar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Encaminhamento"));

        jLabel1.setText("Especialidade");

        jLabel2.setText("Data");

        cbEspecialidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nome:");

        jButton1.setText("Localizar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(dtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Descrição");

        txDescricao.setColumns(20);
        txDescricao.setRows(5);
        jScrollPane1.setViewportView(txDescricao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEncaminhar.setText("Encaminhar");

        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEncaminhar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEncaminhar)
                    .addComponent(btnSair))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.telaBusca = new TelaPacientePesquisa(this, true);
this.telaBusca.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
setInserir(true);
    salvar();
}//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaEncaminhamento dialog = new TelaEncaminhamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncaminhar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbEspecialidade;
    private org.jdesktop.swingx.JXDatePicker dtData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JTextArea txDescricao;
    // End of variables declaration//GEN-END:variables


    protected void carregarCbEspecialidade() {
        this.cbEspecialidade.removeAllItems();
        this.cbEspecialidade.addItem("SELECIONE");

        try {
            this.especialidadeDao = new EspecialidadeDAO();
            esps = this.especialidadeDao.getLista();
            for (EspecialidadeBean esp : esps) {
                this.cbEspecialidade.addItem(esp.getNome().trim().toUpperCase());
                this.nomeEspecialidade = esp.getNome();
            }
        } catch (Exception e) {
            Msg.erro(this, "Erro ao atualizar especialidades. \n" + e.getMessage());
        }
    }
    
     protected void preencherCampos(int id) {
        try {

            this.idPac = id;


            this.pacientedao = new pacienteDAO();
            PacienteBean paciente = pacientedao.getPaciente(id);

           
            this.idPaciente = paciente.getIdPaciente();
            this.lbNome.setText(paciente.getNome().trim().toUpperCase());
            this.nomePaciente = paciente.getNome();
            
        } catch (SQLException ex) {
            Msg.erro(this, "Erro ao preencher campos. \n" + ex.getMessage());
        }

    }
      private void destacarCampo(Component c, boolean b) {
        if (b) {
            c.setBackground(Params.COR_CAMPO_VAZIO);
        } else {
            c.setBackground(Params.COR_CAMPO_NORMAL);
        }
    }
     
      private boolean verificarCampos() {
        boolean aux = false;
        String msg = "Preencha corretamente os campos. \n";



        if (this.txDescricao.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txDescricao, aux);

        }
        



        if (aux) {
            Msg.alerta(this, msg);
        }
        return aux;
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


                EncaminhamentoBean enca = new EncaminhamentoBean();
                enca.setDescricao(txDescricao.getText().trim().toUpperCase());
                enca.setData(dtData.getDate());
                enca.setNomeEspecialidade(this.nomeEspecialidade);
                enca.setNomePaciente(this.nomePaciente);
                
                

                EncaminhamentoDAO encaDao = new EncaminhamentoDAO();
                encaDao.inserir(enca);
                Msg.informacao(this, "Salvo com sucesso.");
                
               
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
            Msg.erro(this, "Erro ao salvar. \n" + ex.getMessage());
        }
    }

}
