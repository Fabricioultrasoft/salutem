package salutem.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.ModuloBean;
import salutem.conexao.MySQL;

/**
 * 
 * @author Renato Doretto
 */
public class ModuloDAO extends MySQL {

    public void inserir(ModuloBean modulo) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "INSERT INTO modulo (idModulo, idModuloPai, descricao) "
                + "VALUES(?, " + (modulo.getModuloPai() == null ? "NULL" : modulo.getModuloPai().getIdModulo()) + ", ?, ?)";
        this.prepare(SQL);
        this.setInt(1, modulo.getIdModulo());
        this.setString(2, modulo.getDescricao());
        this.execute();

        this.close();
    }

    public void alterar(ModuloBean modulo) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "UPDATE modulo SET modulo.descricao = ?, modulo.idModuloPai = "
                + (modulo.getModuloPai() == null ? "NULL" : modulo.getModuloPai().getIdModulo()) + " WHERE modulo.idModulo = ?";
        this.prepare(SQL);
        this.setString(1, modulo.getDescricao());
        this.setInt(2, modulo.getIdModulo());
        this.execute();

        this.close();
    }

    public void excluir(int id) throws SQLException {
        this.setConnection("sal");
        this.open();
        this.startTransaction();

        String SQL = "DELETE FROM permissao WHERE idModulo = " + id;
        this.prepare(SQL);
        this.execute();

        SQL = "DELETE FROM modulo WHERE modulo.idModulo = " + id;
        this.prepare(SQL);
        this.execute();

        this.commit();
        this.close();
    }

    public List<ModuloBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT modulo.idModulo, modulo.descricao, "
                + "modulo.idModuloPai AS mPaiID, mPai.descricao AS mPaiDS "
                + "FROM modulo LEFT OUTER JOIN modulo AS mPai "
                + "ON modulo.idModuloPai = mPai.idModulo";
        this.prepare(SQL);
        this.executeQuery();

        List<ModuloBean> lista = new ArrayList<ModuloBean>();
        while (this.getRS().next()) {
            ModuloBean modPai = new ModuloBean();
            modPai.setIdModulo(this.getRS().getInt("mPaiID"));
            modPai.setModuloPai(null);
            modPai.setDescricao(this.getRS().getString("mPaiDS"));

            ModuloBean modulo = new ModuloBean();
            modulo.setIdModulo(this.getRS().getInt("idModulo"));
            modulo.setModuloPai(modPai);
            modulo.setDescricao(this.getRS().getString("descricao"));
            lista.add(modulo);
        }

        this.close();

        return lista;
    }

    public ModuloBean getModulo(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT modulo.idModulo, modulo.descricao, modulo.nomeJar, "
                + "modulo.idModuloPai AS mPaiID, mPai.descricao AS mPaiDS "
                + "FROM modulo LEFT OUTER JOIN modulo AS mPai "
                + "ON modulo.idModuloPai = mPai.idModulo "
                + "WHERE modulo.idModulo = " + id;
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().next();

        ModuloBean modPai = new ModuloBean();
        modPai.setIdModulo(this.getRS().getInt("mPaiID"));
        modPai.setModuloPai(null);
        modPai.setDescricao(this.getRS().getString("mPaiDS"));

        ModuloBean modulo = new ModuloBean();
        modulo.setIdModulo(this.getRS().getInt("idModulo"));
        modulo.setModuloPai(modPai);
        modulo.setDescricao(this.getRS().getString("descricao"));

        this.close();

        return modulo;
    }

    public int getCodigo() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT IFNULL(MAX(idModulo),0)+1 AS ID FROM modulo";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();
        int novoId = this.getRS().getInt("ID");

        this.close();
        return novoId;
    }

    // Consulta o menu verificando se o funcionário tem permissão
    public ResultSet consultarModulo(int idFuncionario, Integer idModuloPai) throws SQLException {
        String SQL = "SELECT modulo.*, ("
                + "     SELECT COUNT(*) FROM modulo AS subModulo "
                + "     WHERE subModulo.idModuloPai = modulo.idModulo "
                + ") AS Itens, EXISTS ( "
                + "     SELECT NULL FROM permissao "
                + "     WHERE permissao.idModulo = modulo.idModulo "
                + "     AND permissao.idFuncionario = " + idFuncionario + " LIMIT 1 "
                + ") AS temAcesso "
                + "FROM modulo "
                + "WHERE modulo.idModuloPai " + (idModuloPai == null ? "IS NULL" : "= " + idModuloPai)
                + " GROUP BY modulo.idModulo "
                + "ORDER BY modulo.descricao ASC";
        this.prepare(SQL);
        this.executeQuery();
        return this.getRS();
    }

    public ResultSet consultarModuloFiltro(Integer idModuloPai) throws SQLException {
        String SQL = "SELECT modulo.*, ("
                + "     SELECT COUNT(*) FROM modulo AS subModulo "
                + "     WHERE subModulo.idModuloPai = modulo.idModulo "
                + ") AS Itens "
                + "FROM modulo "
                + "WHERE modulo.idModuloPai " + (idModuloPai == null ? "IS NULL" : "= " + idModuloPai)
                + " GROUP BY modulo.idModulo "
                + "ORDER BY modulo.descricao ASC";
        this.prepare(SQL);
        this.executeQuery();
        return this.getRS();
    }

    public int getTotalModulos() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT COUNT(*) AS TOTAL FROM modulo";

        this.prepare(SQL);
        this.executeQuery();
        this.getRS().next();

        int total = this.getRS().getInt("TOTAL");

        this.close();

        return total;
    }
}
