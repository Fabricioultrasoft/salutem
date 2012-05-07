package salutem.Utils;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import javax.swing.JDialog;
import javax.swing.JFrame;
import salutem.Beans.ModuloBean;
import salutem.Telas.TelaPrincipal;

/**
 * 
 * @author Renato Doretto
 */
public class MenuDinamico extends MouseAdapter implements ActionListener {

    private final String PACOTE_PADRAO = "salutem.Telas";
    private JFrame telaPrincipal;
    private String nomeClasse;
    private ModuloBean modulo;

    public MenuDinamico(JFrame telaPrincipal, String nomeClasse, ModuloBean modulo) {
        this.telaPrincipal = telaPrincipal;
        this.modulo = modulo;
        this.nomeClasse = this.PACOTE_PADRAO + "." + nomeClasse;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.abrirModulo();
    }

    public void actionPerformed(ActionEvent e) {
        this.abrirModulo();
    }

    private void abrirModulo() {
        Class classe = null;
        try {
            classe = Class.forName(this.nomeClasse);

            Constructor cons = classe.getDeclaredConstructor(Frame.class, boolean.class);
            JDialog janela = (JDialog) cons.newInstance(this.telaPrincipal, true);

            ((TelaPrincipal) this.telaPrincipal).setModulo(this.modulo);

            janela.setLocationRelativeTo(this.telaPrincipal);
            janela.setVisible(true);
        } catch (Exception ex) {
            Msg.erro(this.telaPrincipal, "Erro: " + ex.getMessage());
        }
    }
}
