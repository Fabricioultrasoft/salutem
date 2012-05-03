package salutem.Utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 * @author Sandro Alves Peres
 * @version 1.0
 * @since 2011-03-19
 * @email sandrinhodobanjo@yahoo.com.br
 */
public class Utils {

    public static void maximizar(JDialog janela) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new Dimension((int) screen.getWidth(), (int) screen.getHeight() - 30);
        janela.setSize(screen);
        janela.setLocationRelativeTo(null);
    }

    public static void configTabela(JTable tabela, int[] largura) {
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < largura.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(largura[i]);

            if (largura[i] <= 0) {
                tabela.getColumnModel().getColumn(i).setMinWidth(0);
                tabela.getColumnModel().getColumn(i).setMaxWidth(0);
            }
        }
    }

    public static Date convertData(String date) {
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            Msg.erro(null, "Erro ao converter data!!!\n\n" + ex.getMessage());
        }
        return data;
    }

    public static String convertData(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static void copyFile(String srcFrom, String srcTo) throws IOException {
        if (srcFrom.equalsIgnoreCase(srcTo)) {
            return;
        }
        // Create channel on the source
        FileChannel srcChannel = new FileInputStream(srcFrom).getChannel();
        // Create channel on the destination
        FileChannel dstChannel = new FileOutputStream(srcTo).getChannel();
        // Copy file contents from source to destination
        dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
        // Close the channels
        srcChannel.close();
        dstChannel.close();
    }

    public static String getExtFile(String file) {
        String arr[] = file.split("[\\.]");

        if (arr.length < 2) {
            return null;
        }
        return arr[arr.length - 1].trim().toLowerCase();
    }

    public static void deleteFile(String srcFile) {
        File file = new File(srcFile);

        if (file.isFile()) {
            file.delete();
        }
    }

    public static void deleteTree(String srcFile) {
        File file = new File(srcFile);

        if (file.isFile()) {
            file.delete();
        } else {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteTree(files[i].getAbsolutePath());
            }
        }
    }

    public static boolean isEmail(String email) {
        String regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{1,3})+$";
        return email.matches(regexp);
    }

    public static boolean isCPF(String cpf) {
        boolean retorno = true;

        if (cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            try {
                cpf = cpf.replace(".", "");
                cpf = cpf.replace("-", "");

                String cpfV = "";
                for (int i = 0; i <= 9; i++) {
                    cpfV = "";
                    for (int j = 1; j <= 11; j++) {
                        cpfV += i;
                    }
                    if (cpfV.equals(cpf)) {
                        return false;
                    }
                }

                int digito[] = new int[11];
                int dvInformado = Integer.parseInt(cpf.substring(9, 11));

                for (int i = 0; i <= 8; i++) {
                    digito[i] = Integer.parseInt(cpf.substring(i, i + 1));
                }

                int posicao = 10;
                int soma = 0;

                for (int i = 0; i <= 8; i++) {
                    soma = (soma + digito[i] * posicao);
                    posicao = (posicao - 1);
                }

                digito[9] = (soma % 11);

                if (digito[9] < 2) {
                    digito[9] = 0;
                } else {
                    digito[9] = (11 - digito[9]);
                }

                posicao = 11;
                soma = 0;

                for (int i = 0; i <= 9; i++) {
                    soma = (soma + digito[i] * posicao);
                    posicao = (posicao - 1);
                }

                digito[10] = (soma % 11);

                if (digito[10] < 2) {
                    digito[10] = 0;
                } else {
                    digito[10] = (11 - digito[10]);
                }

                int dv = (digito[9] * 10 + digito[10]);

                if (dv != dvInformado) {
                    retorno = false;
                }
            } catch (Exception e) {
                retorno = false;
            }
        } else {
            retorno = false;
        }

        return retorno;
    }

    public static boolean isCNPJ(String cnpj) {
        boolean retorno = true;

        if (!cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            return false;
        }

        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");

        int a[] = new int[14];
        int x = 0, b = 0;
        int c[] = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < 12; i++) {
            a[i] = Integer.parseInt(cnpj.substring(i, i + 1));
            b += (a[i] * c[i + 1]);
        }

        if ((x = b % 11) < 2) {
            a[12] = 0;
        } else {
            a[12] = (11 - x);
        }

        b = 0;
        for (int y = 0; y < 13; y++) {
            b += (a[y] * c[y]);
        }

        if ((float) (x = b % 11) < 2) {
            a[13] = 0;
        } else {
            a[13] = (11 - x);
        }

        int pos12 = Integer.parseInt(cnpj.substring(12, 13));
        int pos13 = Integer.parseInt(cnpj.substring(13, 14));

        if ((pos12 != a[12]) || (pos13 != a[13])) {
            retorno = false;
        }

        return retorno;
    }
}
