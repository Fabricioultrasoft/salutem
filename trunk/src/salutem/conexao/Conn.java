package salutem.conexao;

import java.util.HashMap;
import javax.swing.JOptionPane;
import salutem.Utils.Encrypter;
import salutem.Utils.IniFiles;


public class Conn {

    private HashMap connections;
    private String host;
    private String port;
    private String user;
    private String password;
    private String database;

    protected Conn() {
        this.connections = new HashMap();
//        IniFiles ini = new IniFiles("c:\\config.ini");
        IniFiles ini = new IniFiles("config.ini");
        String host = null;
        String user = null;
        String pass = null;
        String port = null;
        String base = null;
        try {
            host = Encrypter.decrypt(ini.getString("CONEXAO", "host"));
            user = Encrypter.decrypt(ini.getString("CONEXAO", "user"));
            pass = Encrypter.decrypt(ini.getString("CONEXAO", "pass"));
            port = Encrypter.decrypt(ini.getString("CONEXAO", "port"));
            base = Encrypter.decrypt(ini.getString("CONEXAO", "base"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir .ini: " + ex.getMessage());
        }

        this.connections.put("sal", new Conn(host, port, user, pass, base));
    }

    private Conn(String host, String port, String user, String password, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public HashMap getConnections() {
        return connections;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }
}
