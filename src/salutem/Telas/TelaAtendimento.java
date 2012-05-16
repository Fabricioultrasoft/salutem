/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaAtendimento.java
 *
 * Created on 11/05/2012, 14:45:28
 */
package salutem.Telas;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.sun.media.codec.audio.msadpcm.MsAdpcm;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import salutem.Beans.AtendimentoBean;
import salutem.Beans.PacienteBean;
import salutem.Beans.PreAtendimentoBean;
import salutem.DAO.AtendimentoDAO;
import salutem.DAO.PreAtendimentoDAO;
import salutem.DAO.pacienteDAO;
import salutem.Utils.Msg;
import salutem.Utils.Params;
import salutem.Utils.Utils;

/**
 *
 * @author Tironi
 */
public class TelaAtendimento extends javax.swing.JDialog {
    private Integer idPaciente;
    private Integer idAtendimento;
    private Integer idPreAtendimento;
    private int idPac;
    private int temperatura;
    private int alta;
    private int baixa;
    private pacienteDAO pacientedao = new pacienteDAO();
    private TelaPacientePesquisa telaBusca;
    private boolean inserir;
    private AtendimentoDAO atendimentoDao;
    private PreAtendimentoDAO preDao;
    
    

    /** Creates new form TelaAtendimento */
    public TelaAtendimento(TelaPacientePesquisa parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.telaBusca = parent;
        this.atendimentoDao = new AtendimentoDAO();
        this.preDao = new PreAtendimentoDAO();
       
         
        
    }
     public TelaAtendimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitarCampos();
        
       
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
        btnPesquisaPaciente = new javax.swing.JButton();
        lbNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        lbIdade = new javax.swing.JLabel();
        lbArterial = new javax.swing.JLabel();
        lbTemperatura = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txAlta = new javax.swing.JLabel();
        txBaixa = new javax.swing.JLabel();
        txTemp = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txDescricaoHis = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txMedicamentosHis = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txDiagnostico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txDescricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        dtAtendimento = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txMedicamento = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Paciente"));

        jLabel1.setText("Nome:");

        btnPesquisaPaciente.setText("Localizar Paciente");
        btnPesquisaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaPacienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Data de Nascimento:");

        jLabel3.setText("Idade:");

        jLabel4.setText("Pressão Arterial");

        jLabel5.setText("Temperatura:");

        jLabel10.setText("Alta:");

        jLabel11.setText("Baixa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                        .addComponent(btnPesquisaPaciente)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDataNascimento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIdade))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lbArterial)
                        .addGap(90, 90, 90)
                        .addComponent(lbTemperatura))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTemp)
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txAlta)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txBaixa)))
                        .addGap(556, 556, 556))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbNome)
                    .addComponent(btnPesquisaPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txTemp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(txAlta)
                            .addComponent(txBaixa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbArterial)
                    .addComponent(lbTemperatura))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico Recente"));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Diagnóstico", "Descrição", "Temperatura", "Pressão Arterial Alta", "Pressão Arterial Baixa", "Unidade", "Funcionario"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        txDescricaoHis.setColumns(20);
        txDescricaoHis.setRows(5);
        jScrollPane4.setViewportView(txDescricaoHis);

        txMedicamentosHis.setColumns(20);
        txMedicamentosHis.setRows(5);
        jScrollPane5.setViewportView(txMedicamentosHis);

        jLabel12.setText("Descrição");

        jLabel13.setText("Medicamentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Atendimento"));

        jLabel6.setText("Diagnóstico");

        jLabel7.setText("Descrição");

        txDescricao.setColumns(20);
        txDescricao.setRows(5);
        jScrollPane2.setViewportView(txDescricao);

        jLabel8.setText("Data Atendimento");

        jLabel9.setText("Medicamento");

        txMedicamento.setColumns(20);
        txMedicamento.setRows(5);
        jScrollPane3.setViewportView(txMedicamento);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dtAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("Gerar Receita");

        jButton3.setText("Cancelar");

        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnPesquisaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaPacienteActionPerformed
telaBusca = new TelaPacientePesquisa(this, true);
this.telaBusca.setVisible(true);
}//GEN-LAST:event_btnPesquisaPacienteActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
setInserir(true);
salvar();
}//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaAtendimento dialog = new TelaAtendimento(new javax.swing.JFrame(), true);
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
    
     protected void setInserir(boolean inserir) {
        this.inserir = inserir;
        this.idPaciente = null;
    }
     
      protected boolean isInserir() {
        return inserir;
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



        if (this.txDiagnostico.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txDiagnostico, aux);

        }
        
        if (this.txDescricao.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txDescricao, aux);

        }    
        
         if (this.txMedicamento.getText().isEmpty()) {
            aux = true;
            this.destacarCampo(this.txMedicamento, aux);

        }    
        

        if (aux) {
            Msg.alerta(this, msg);
        }
        return aux;
    }

    
   protected void atualizarTabela(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
            modelo.setNumRows(0);
            
           this.atendimentoDao = new AtendimentoDAO();

            List<AtendimentoBean> lista = this.atendimentoDao.getLista(this.idPac);

            for(int i=0; i< lista.size(); i++){
                modelo.addRow(new Object[]{
                lista.get(i).getData(),
                lista.get(i).getDiagnostico(),
                lista.get(i).getDescricao(),
                lista.get(i).getTemperatura(),
                lista.get(i).getAlta(),
                lista.get(i).getBaixa(),
                lista.get(i).getIdPaciente(),                
                lista.get(i).getMedicamento(),
                             
                });
                
            }
           

        }catch(SQLException ex){
            Msg.erro(this, "Erro ao atualizar tabela. \n"+ex.getMessage());
        }
    }
   public void desabilitarCampos(){
       this.txDescricaoHis.enable(true);
       this.txMedicamentosHis.enable(true);
   }
   
    
   protected void preencherCampos(int id) {
        try {

            this.idPac = id;
            
            
            
            PacienteBean paciente = pacientedao.getPaciente(id);
                        
            Utils util = new Utils();

            this.idPaciente = paciente.getIdPaciente();
            this.lbNome.setText(paciente.getNome().trim().toUpperCase());
            this.lbDataNascimento.setText(util.convertData(paciente.getData()));
           
             this.atendimentoDao = new AtendimentoDAO();
             AtendimentoBean atend = this.atendimentoDao.getPaciente(id);
             this.idAtendimento = atend.getIdAtendimento();
             this.txMedicamentosHis.setText(atend.getMedicamento());
             this.txDescricaoHis.setText(atend.getDescricao());
             
            
            this.preDao = new PreAtendimentoDAO();
            PreAtendimentoBean pre = preDao.getUltimoAtendimento(id);
            this.idPreAtendimento = pre.getIdPreAtendimento();
            this.txTemp.setText(String.valueOf(pre.getTemperatura()));
            this.txAlta.setText(String.valueOf(pre.getAlta()));
            this.txBaixa.setText(String.valueOf(pre.getBaixa()));
            
            this.temperatura = pre.getTemperatura();
            this.alta = pre.getAlta();
            this.baixa = pre.getBaixa();
            
            atualizarTabela();
            
           



        } catch (SQLException ex) {
            Msg.erro(this, "Erro ao preencher campos. \n" + ex.getMessage());
        }
       
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
                
                

                AtendimentoBean atendimento = new AtendimentoBean();
                atendimento.setDiagnostico(txDiagnostico.getText().trim().toUpperCase());
                atendimento.setDescricao(txDescricao.getText().trim().toUpperCase());
                atendimento.setIdPaciente(this.idPac);
                atendimento.setData(dtAtendimento.getDate());
                atendimento.setMedicamento(txMedicamento.getText().trim().toUpperCase());
                atendimento.setTemperatura(this.temperatura);
                atendimento.setAlta(this.alta);
                atendimento.setBaixa(this.baixa);
                
                
               
                
                this.atendimentoDao = new AtendimentoDAO();
                this.atendimentoDao.inserir(atendimento);
                Msg.informacao(this, "Salvo com sucesso.");
                //telaBusca = new TelaPacienteBusca(null, inserir);
                this.telaBusca.atualizarTabela();
                this.cancelar();
            } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Msg.erro(this, "Erro ao salvar. \n" + ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisaPaciente;
    private org.jdesktop.swingx.JXDatePicker dtAtendimento;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbArterial;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTemperatura;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txAlta;
    private javax.swing.JLabel txBaixa;
    private javax.swing.JTextArea txDescricao;
    private javax.swing.JTextArea txDescricaoHis;
    private javax.swing.JTextField txDiagnostico;
    private javax.swing.JTextArea txMedicamento;
    private javax.swing.JTextArea txMedicamentosHis;
    private javax.swing.JLabel txTemp;
    // End of variables declaration//GEN-END:variables
}