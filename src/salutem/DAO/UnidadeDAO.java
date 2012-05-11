/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.UnidadeBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class UnidadeDAO extends MySQL {

    public void inserir(UnidadeBean uni) throws SQLException {
        this.setConnection("sal");
        this.open();

        int id = this.getCodigo();

        String SQL = "INSERT INTO unidade (idUnidade, nome, rua, numero, "
                + "bairro, complemento) "
                + "VALUES (?,?,?,?,?,?)";
        this.prepare(SQL);
        this.setInt(1, id);
        this.setString(2, uni.getNome());
        this.setString(3, uni.getRua());
        this.setInt(4, uni.getNumero());
        this.setString(5, uni.getBairro());
        this.setString(6, uni.getComplemento());
        this.execute();
        this.close();
    }

    public void alterar(UnidadeBean uni) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "UPDATE unidade SET nome = ?, rua = ?, numero = ?, "
                + "bairro = ?, complemento = ?, WHERE idUnidade = ?";
        this.prepare(SQL);
        this.setString(1, uni.getNome());
        this.setString(2, uni.getRua());
        this.setInt(3, uni.getNumero());
        this.setString(4, uni.getBairro());
        this.setString(5, uni.getComplemento());
        this.setInt(6, uni.getIdUnidade());
        this.execute();
        this.close();
    }

    public void excluir(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM unidade WHERE idUnidade = " + id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public List<UnidadeBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM unidade";
        this.prepare(SQL);
        this.executeQuery();

        List<UnidadeBean> listaUni = new ArrayList<UnidadeBean>();
        while (this.getRS().next()) {
            UnidadeBean uni = new UnidadeBean();
            uni.setIdUnidade(this.getRS().getInt("idUnidade"));
            uni.setNome(this.getRS().getString("nome"));
            uni.setRua(this.getRS().getString("rua"));
            uni.setNumero(this.getRS().getInt("numero"));
            uni.setBairro(this.getRS().getString("bairro"));
            uni.setComplemento(this.getRS().getString("complemento"));
            listaUni.add(uni);
        }

        this.close();

        return listaUni;
    }

    public List<UnidadeBean> getLista(String filtro) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM unidade WHERE nome LIKE '%" + filtro + "%'";
        this.prepare(SQL);
        this.executeQuery();

        List<UnidadeBean> listaUni = new ArrayList<UnidadeBean>();
        while (this.getRS().next()) {
            UnidadeBean uni = new UnidadeBean();
            uni.setIdUnidade(this.getRS().getInt("idUnidade"));
            uni.setNome(this.getRS().getString("nome"));
            uni.setRua(this.getRS().getString("rua"));
            uni.setNumero(this.getRS().getInt("numero"));
            uni.setBairro(this.getRS().getString("bairro"));
            uni.setComplemento(this.getRS().getString("complemento"));
            listaUni.add(uni);
        }

        this.close();

        return listaUni;
    }

    public UnidadeBean getUnidade(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM unidade WHERE idUnidade = " + id;
        this.prepare(SQL);
        this.getRS().first();
        UnidadeBean uni = new UnidadeBean();
        uni.setIdUnidade(this.getRS().getInt("idUnidade"));
        uni.setNome(this.getRS().getString("nome"));
        uni.setRua(this.getRS().getString("rua"));
        uni.setNumero(this.getRS().getInt("numero"));
        uni.setBairro(this.getRS().getString("bairro"));
        uni.setComplemento(this.getRS().getString("complemento"));

        this.close();

        return uni;

    }

    public int getCodigo() throws SQLException {
        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idEspecialidade),0)+1 AS ID FROM especialidade";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        return novoId;
    }
}
