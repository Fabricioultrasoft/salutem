/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCargo.java
 *
 * Created on 11/05/2012, 14:31:04
 */

package salutem.Telas;

import com.mysql.jdbc.Util;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import salutem.Beans.CargoBean;
import salutem.DAO.CargoDAO;
import salutem.Utils.Msg;
import salutem.Utils.Utils;

/**
 *
 * @author Renato Doretto
 */
public class TelaCargo extends javax.swing.JDialog {

    private CargoDAO daoCargo;
    private TelaPrincipal telaP;
    
    public TelaCargo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.telaP = (TelaPrincipal) parent;
        this.daoCargo = new CargoDAO();

        Utils.maximizar(this);
        this.tabela.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabela.getColumnModel().getColumn(0).setMinWidth(0);
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
        txPesquisar = new javax.swing.JTextField();
        btTodos = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        lbInfoPesq = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btInserir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        btTodos.setText("Exibir Todos");
        btTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodosActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        lbInfoPesq.setPreferredSize(new java.awt.Dimension(0, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbInfoPesq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(txPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTodos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTodos)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInfoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-inserir.png"))); // NOI18N
        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-deletar.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-help.png"))); // NOI18N
        btAjuda.setText("Ajuda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAjuda)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btAjuda)
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        this.pesquisar();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodosActionPerformed
        this.atualizarTabela();
    }//GEN-LAST:event_btTodosActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        this.inserir();
    }//GEN-LAST:event_btInserirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        this.alterar();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.sair();
    }//GEN-LAST:event_btSairActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCargo dialog = new TelaCargo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjuda;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btTodos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbInfoPesq;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txPesquisar;
    // End of variables declaration//GEN-END:variables

    private void sair(){
        this.setVisible(false);
        this.dispose();
    }

    protected void atualizarTabela(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
            modelo.setNumRows(0);

            List<CargoBean> listaCargo = this.daoCargo.getLista();

            for(int i=0; i < listaCargo.size(); i++){
                modelo.addRow(new Object[]{
                listaCargo.get(i).getIdCargo(),
                listaCargo.get(i).getDescricao()});
            }
            this.lbInfoPesq.setText(modelo.getRowCount()+ " resultado(s).");
        }catch(SQLException ex){
            Msg.erro(this, "Erro ao atualizar tabela. \n"+ex.getMessage());
        }
    }

    protected void atualizarTabela(String filtro){
        try{
            DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
            modelo.setNumRows(0);

            List<CargoBean> listaCargo = this.daoCargo.getLista(filtro);

            for(int i=0; i < listaCargo.size(); i++){
                modelo.addRow(new Object[]{
                listaCargo.get(i).getIdCargo(),
                listaCargo.get(i).getDescricao()});
            }
            this.lbInfoPesq.setText(modelo.getRowCount()+ " resultado(s).");
        }catch(SQLException ex){
            Msg.erro(this, "Erro ao atualizar tabela. \n"+ex.getMessage());
        }
    }

    protected void limparTabela(){
        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        modelo.setNumRows(0);
        this.lbInfoPesq.setText("");
    }

    private void pesquisar(){
        if(this.txPesquisar.getText().length() >= 3){
            this.atualizarTabela(this.txPesquisar.getText().trim());
        }else{
            this.lbInfoPesq.setText("Digite no minímo 3 caracteres.");
        }
    }

    public void inserir(){
        TelaCargoCadastro tela = new TelaCargoCadastro(this, true);
        tela.setTitle("INSERIR CARGO");
        tela.setInserir(true);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    public void alterar(){
        int row = this.tabela.getSelectedRow();
        if(row == -1){
            Msg.alerta(this, "Selecione o registro.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        int id = Integer.parseInt(modelo.getValueAt(row, 0).toString());

        TelaCargoCadastro tela = new TelaCargoCadastro(this, true);
        tela.setTitle("ALTERAR CARGO");
        tela.setInserir(false);
        tela.setLocationRelativeTo(null);
        
        tela.setVisible(true);
    }

    private void excluir(){
        int row = this.tabela.getSelectedRow();
        if(row == -1){
            Msg.alerta(this, "Selecione o registro.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        int id = Integer.parseInt(modelo.getValueAt(row, 0).toString());
        String cargo = modelo.getValueAt(row, 1).toString();

        if(Msg.confirmar(this, "Deseja excluir o registro \""+cargo+"\"?")){
            try{
                this.daoCargo.excluir(id);
                this.atualizarTabela();
            }catch(SQLException ex){
                if(ex.getMessage().startsWith("Cannot delete or update a parent row")){
                    Msg.erro(this, "Registro tem referência com outros módulos.\n\nNão pode ser excluído.");
                }else{
                    Msg.erro(this, "Erro ao excluir o registro.\n\n"+ex.getMessage());
                }
            }
        }
    }
}
