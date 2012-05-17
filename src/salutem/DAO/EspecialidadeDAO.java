/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.EspecialidadeBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class EspecialidadeDAO extends MySQL {

    public void inserir(EspecialidadeBean esp) throws SQLException {
        this.setConnection("sal");
        this.open();

        int id = this.getCodigo();

        String SQL = "INSERT INTO especialidade (idEspecialidade, nomeEsp) VALUES (?,?)";
        this.prepare(SQL);
        this.setInt(1, id);
        this.setString(2, esp.getNome());
        this.execute();
        this.close();
    }

    public void alterar(EspecialidadeBean esp) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "UPDATE especialidade SET nome = ? WHERE idEspecialidade = ?";
        this.prepare(SQL);
        this.setString(1, esp.getNome());
        this.setInt(2, esp.getIdEspecialidade());
        this.execute();
        this.close();
    }

    public void excluir(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM especialidade WHERE idEspecialidade = " + id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public List<EspecialidadeBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM especialidade";
        this.prepare(SQL);
        this.executeQuery();

        List<EspecialidadeBean> listaEsp = new ArrayList<EspecialidadeBean>();
        while (this.getRS().next()) {
            EspecialidadeBean esp = new EspecialidadeBean();
            esp.setIdEspecialidade(this.getRS().getInt("idEspecialidade"));
            esp.setNome(this.getRS().getString("nomeEsp"));
            listaEsp.add(esp);
        }

        this.close();

        return listaEsp;
    }

    public List<EspecialidadeBean> getLista(String filtro) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM especialidade WHERE nome LIKE '%"+filtro+"%'";
        this.prepare(SQL);
        this.executeQuery();

        List<EspecialidadeBean> listaEsp = new ArrayList<EspecialidadeBean>();
        while (this.getRS().next()) {
            EspecialidadeBean esp = new EspecialidadeBean();
            esp.setIdEspecialidade(this.getRS().getInt("idEspecialidade"));
            esp.setNome(this.getRS().getString("nome"));
            listaEsp.add(esp);
        }

        this.close();

        return listaEsp;
    }

    public EspecialidadeBean getEspecialidade(int id)throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM especialidade WHERE idEspecialidade = "+id;
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();
        EspecialidadeBean esp = new EspecialidadeBean();
        esp.setIdEspecialidade(this.getRS().getInt("idEspecialidade"));
        esp.setNome(this.getRS().getString("nomeEsp"));

        this.close();
        return esp;

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
