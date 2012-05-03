package salutem.conexao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;


public class MySQL extends Conn {

    private String con[];
    private Connection openedCon;
    private ResultSet RSet;
    private PreparedStatement stmt;

    public MySQL() {
        this.con = new String[5];
    }

    public MySQL(Object key) {
        this.con = new String[5];
        this.setConnection(key);
    }

    public MySQL(Object key, boolean connect) {
        this.con = new String[5];
        this.setConnection(key);

        if (connect) {
            this.open();
        }
    }

    public void setConnection(Object key) {
        this.con = new String[5];
        this.con[0] = ((Conn) this.getConnections().get(key)).getHost();
        this.con[1] = ((Conn) this.getConnections().get(key)).getPort();
        this.con[2] = ((Conn) this.getConnections().get(key)).getUser();
        this.con[3] = ((Conn) this.getConnections().get(key)).getPassword();
        this.con[4] = ((Conn) this.getConnections().get(key)).getDatabase();
    }

    public void setConnection(String host, String port, String user, String password, String database) {
        this.con = new String[5];
        this.con[0] = host;
        this.con[1] = port;
        this.con[2] = user;
        this.con[3] = password;
        this.con[4] = database;
    }

    public boolean open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + this.con[0] + ":" + this.con[1] + "/" + this.con[4];
            this.openedCon = DriverManager.getConnection(url, this.con[2], this.con[3]);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO!!!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void close() {
        try {
            this.openedCon.close();
            this.stmt.close();
            this.RSet.close();
        } catch (Exception e) {
        }
    }

    public void prepare(String SQL) throws SQLException {
        this.stmt = this.openedCon.prepareStatement(SQL);
    }

    public void execute() throws SQLException {
        this.stmt.execute();
    }

    public void setString(int param, String var) throws SQLException {
        this.stmt.setString(param, var);
    }

    public void setInt(int param, int var) throws SQLException {
        this.stmt.setInt(param, var);
    }

    public void setShort(int param, short var) throws SQLException {
        this.stmt.setShort(param, var);
    }

    public void setByte(int param, byte var) throws SQLException {
        this.stmt.setByte(param, var);
    }

    public void setBytes(int param, byte[] var) throws SQLException {
        this.stmt.setBytes(param, var);
    }

    public void setLong(int param, long var) throws SQLException {
        this.stmt.setLong(param, var);
    }

    public void setDouble(int param, double var) throws SQLException {
        this.stmt.setDouble(param, var);
    }

    public void setFloat(int param, float var) throws SQLException {
        this.stmt.setFloat(param, var);
    }

    public void setBoolean(int param, boolean var) throws SQLException {
        this.stmt.setBoolean(param, var);
    }

    public void setDate(int param, Date var) throws SQLException {
        int day = var.getDate();
        int month = var.getMonth();
        int year = var.getYear();
        this.stmt.setDate(param, new java.sql.Date(year, month, day));
    }

    public void setObject(int param, Object var) throws SQLException {
        this.stmt.setObject(param, var);
    }

    public void setBinaryStream(int param, InputStream stream, int len) throws SQLException {
        this.stmt.setBinaryStream(param, stream, len);
    }

    public void setAsciiStream(int param, InputStream stream, int len) throws SQLException {
        this.stmt.setAsciiStream(param, stream, len);
    }

    public void setNull(int param, int sqlType) {
        this.setNull(param, sqlType);
    }

    public void clearParameters() throws SQLException {
        this.stmt.clearParameters();
    }

    public void executeQuery() throws SQLException {
        this.RSet = this.stmt.executeQuery();
    }

    public ResultSet getRS() {
        return this.RSet;
    }

    public Connection getConnection() {
        return this.openedCon;
    }

    public void startTransaction() throws SQLException {
        this.prepare("START TRANSACTION");
        this.stmt.execute();
    }

    public void begin() throws SQLException {
        this.prepare("BEGIN");
        this.stmt.execute();
    }

    public void rollback() throws SQLException {
        this.prepare("ROLLBACK");
        this.stmt.execute();
    }

    public void commit() throws SQLException {
        this.prepare("COMMIT");
        this.stmt.execute();
    }

    public int getLastAutoID() {
        try {
            this.prepare("SELECT LAST_INSERT_ID() AS LAST_ID");
            this.executeQuery();
            this.getRS().first();
            return this.getRS().getInt("LAST_ID");
        } catch (Exception e) {
            return 0;
        }
    }
}
