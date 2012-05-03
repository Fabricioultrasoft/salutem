/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuDinamicoTeste.java
 *
 * Created on 03/05/2012, 00:15:04
 */
package salutem.Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Tironi
 */
public class MenuDinamicoTeste extends javax.swing.JFrame {

    /** Creates new form MenuDinamicoTeste */
    public MenuDinamicoTeste() {
        initComponents();
        montaMenu();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MenuDinamicoTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDinamicoTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDinamicoTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDinamicoTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuDinamicoTeste().setVisible(true);
            }
        });
    }
    
    public void montaMenu(){

      //criação da barra de menu

      JMenuBar jMenuBar = new JMenuBar();

     

      //criação dos menus

      JMenu jMenuArquivo = new JMenu("Cadastro");

      JMenu jMenuHospital = new JMenu("Hospital");

      JMenu jMenuExibir = new JMenu("Posto de Saúde");

      JMenu jMenuFormatar = new JMenu("Atendimento");

      JMenu jMenuAjuda = new JMenu("Gestor");

 

      //criação dos itens do menu arquivo

      JMenuItem jMenuItemNovo = new JMenuItem("Funcionario");

      JMenuItem jMenuItemAbrir = new JMenuItem("Gerar Receita");

      JMenuItem jMenuItemSalvar = new JMenuItem("Teste");

      JMenuItem jMenuItemSalvarComo = new JMenuItem("Outro Teste");

      JMenuItem jMenuItemSair = new JMenuItem("Sair");

     //Criando Um Itens Menu Para Teste
      
      JMenuItem jMenuItemConsulta = new JMenuItem("Consulta");
      
      JMenuItem jMenuItemMedico = new JMenuItem("Medico");
      
      JMenuItem jMenuItemPaciente = new JMenuItem("Paciente");
      
      

      //adicionando menus à barra de menu

      jMenuBar.add(jMenuArquivo);

      jMenuBar.add(jMenuHospital);

      jMenuBar.add(jMenuExibir);

      jMenuBar.add(jMenuFormatar);

      jMenuBar.add(jMenuAjuda);

                 

      //adicionando itens de menu ao menu arquivo

      jMenuArquivo.add(jMenuItemNovo);

      jMenuArquivo.addSeparator();

      jMenuArquivo.add(jMenuItemAbrir);

      jMenuArquivo.add(jMenuItemSalvar);

      jMenuArquivo.add(jMenuItemSalvarComo);

      jMenuArquivo.addSeparator();

      jMenuArquivo.add(jMenuItemSair);
      
      //Adicionando Menu Hospital
      
      jMenuHospital.add(jMenuItemConsulta);
      
      jMenuHospital.addSeparator();
      
      jMenuHospital.add(jMenuItemMedico);
      
      jMenuHospital.addSeparator();
      
      jMenuHospital.add(jMenuItemPaciente);

     

      //adicionando evento ao item do menu arquivo, sair

      jMenuItemSair.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                  dispose();

            }

      });

       super.setJMenuBar(jMenuBar);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
}
