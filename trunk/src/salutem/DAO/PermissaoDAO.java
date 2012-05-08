package salutem.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class PermissaoDAO extends MySQL {

    public ResultSet consultarMenu(int idUsuario, Integer idModuloPai) throws SQLException {
        String SQL = "SELECT *, ("
                + "    SELECT COUNT(*) FROM permissao AS perm, modulo AS subModulo "
                + "    WHERE perm.idModulo = subModulo.idModulo AND perm.idUsuario = " + idUsuario
                + "    AND subModulo.idModuloPai = modulo.idModulo "
                + ") AS Itens FROM permissao, modulo "
                + "WHERE permissao.idModulo = modulo.idModulo "
                + "AND permissao.idUsuario = " + idUsuario
                + " AND modulo.idModuloPai " + (idModuloPai == null ? "IS NULL" : "= " + idModuloPai)
                + " GROUP BY permissao.idModulo "
                + "ORDER BY modulo.descricao ASC";
        this.prepare(SQL);
        this.executeQuery();
        return this.getRS();
    }
    
}
