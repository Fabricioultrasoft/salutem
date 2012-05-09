/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaFuncionarioCadastro.java
 *
 * Created on 08/05/2012, 13:45:26
 */

package salutem.Telas;

/**
 *
 * @author Renato Doretto
 */
public class TelaFuncionarioCadastro extends javax.swing.JDialog {

    /** Creates new form TelaFuncionarioCadastro */
    public TelaFuncionarioCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        txCpf = new javax.swing.JFormattedTextField();
        lbRg = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        lbSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        lbTelefone = new javax.swing.JLabel();
        txTelefone = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        txCelular = new javax.swing.JFormattedTextField();
        lbRua = new javax.swing.JLabel();
        txRua = new javax.swing.JTextField();
        txNumero = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        lbComplemento = new javax.swing.JLabel();
        txComplemento = new javax.swing.JTextField();
        txBairro = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        lbEstado = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        lbCidade = new javax.swing.JLabel();
        lbDtAdmissao = new javax.swing.JLabel();
        txDtAdmissao = new org.jdesktop.swingx.JXDatePicker();
        lbDecreto = new javax.swing.JLabel();
        txDecreto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salutem/imagens/icone-cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addGap(158, 158, 158))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        lbNome.setText("Nome");

        lbCpf.setText("CPF");

        try {
            txCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbRg.setText("RG");

        lbSexo.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<.SELECIONE.>", "MASCULINO", "FEMININO" }));

        lbTelefone.setText("Telefone");

        try {
            txTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbCelular.setText("Celular");

        try {
            txCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbRua.setText("Rua");

        lbNumero.setText("Número");

        lbComplemento.setText("Complemento");

        lbBairro.setText("Bairro");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<.UF.>" }));

        lbEstado.setText("Estado");

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeActionPerformed(evt);
            }
        });

        lbCidade.setText("Cidade");

        lbDtAdmissao.setText("Data de admissão");

        lbDecreto.setText("Número decreto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSexo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(lbTelefone))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(txCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbRg)
                                            .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                                    .addComponent(lbCelular)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRua)
                            .addComponent(txRua, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero)
                            .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(lbComplemento)
                            .addComponent(lbDtAdmissao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(lbBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, 0, 74, Short.MAX_VALUE)
                                    .addComponent(lbEstado))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCidade)
                                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addComponent(lbDecreto)
                            .addComponent(txDecreto, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lbCpf)
                    .addComponent(lbRg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSexo)
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComplemento)
                    .addComponent(lbBairro)
                    .addComponent(lbEstado)
                    .addComponent(lbCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDtAdmissao)
                    .addComponent(lbDecreto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDecreto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Dados Pessoais", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCidadeActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFuncionarioCadastro dialog = new TelaFuncionarioCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDecreto;
    private javax.swing.JLabel lbDtAdmissao;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JTextField txBairro;
    private javax.swing.JFormattedTextField txCelular;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JFormattedTextField txCpf;
    private javax.swing.JTextField txDecreto;
    private org.jdesktop.swingx.JXDatePicker txDtAdmissao;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txRua;
    private javax.swing.JFormattedTextField txTelefone;
    // End of variables declaration//GEN-END:variables

}