package salutem.Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * @author Sandro Alves Peres
 * @version 1.0
 * @since 2011-03-11
 * @email sandrinhodobanjo@yahoo.com.br
 */
public class Msg {

    public static void alerta(Component frame, Object str) {
        JOptionPane.showMessageDialog(frame, str, "ALERTA", JOptionPane.WARNING_MESSAGE);
    }

    public static void erro(Component frame, Object str) {
        JOptionPane.showMessageDialog(frame, str, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public static void informacao(Component frame, Object str) {
        JOptionPane.showMessageDialog(frame, str, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirmar(Component frame, Object str) {
        Object[] options = {"Sim", "Não"};
        int option = JOptionPane.showOptionDialog(frame, str, "CONFIRMAR", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (option == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
