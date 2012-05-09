/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import salutem.Beans.PacienteBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class pacienteDAO extends MySQL {

    public void inserir(PacienteBean paciente) throws SQLException {
        this.setConnection("sal");
        this.open();

        String sql = "INSERT INTO paciente (idPaciente,nome,cpf,rg,nomeMae,cartaoSus,telefone,celular,rua,complemento,numero,bairro,cidade,estado,sexo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql+" - "+getCodigo());
        this.prepare(sql);
        this.setInt(1, this.getCodigo());
        this.setString(2, paciente.getNome());
        this.setString(3, paciente.getCpfCnpj());
        this.setString(4, paciente.getRgie());
        this.setString(5, paciente.getNomeMae());
        this.setString(6, paciente.getCartaoSus());
        this.setString(7, paciente.getTelefone());
        this.setString(8, paciente.getCelular());
        this.setString(9, paciente.getRua());
        this.setString(10, paciente.getComplemento());
        this.setInt(11, paciente.getNumero());
        this.setString(12, paciente.getBairro());
        this.setString(13, paciente.getCidade());
        this.setString(14, paciente.getEstado());
        this.setString(15, paciente.getSexo());

        this.execute();
        this.close();

    }

    public void alterar(PacienteBean paciente) throws SQLException {
        this.setConnection("sal");
        this.open();

        String sql = "UPDATE paciente SET nome = ?, cpf = ?,rg = ?,nomeMae = ?,cartaoSus = ?,telefone = ?,celular = ?,rua = ?,complemento = ?,numero = ?,bairro = ?,cidade = ?,estado = ?,sexo = ? WHERE idPaciente = ?";

        this.prepare(sql);
        this.setString(1, paciente.getNome());
        this.setString(2, paciente.getCpfCnpj());
        this.setString(3, paciente.getRgie());
        this.setString(4, paciente.getNomeMae());
        this.setString(5, paciente.getCartaoSus());
        this.setString(6, paciente.getTelefone());
        this.setString(7, paciente.getCelular());
        this.setString(8, paciente.getRua());
        this.setString(9, paciente.getComplemento());
        this.setInt(10, paciente.getNumero());
        this.setString(11, paciente.getBairro());
        this.setString(12, paciente.getCidade());
        this.setString(13, paciente.getEstado());
        this.setString(14, paciente.getSexo());
        this.setInt(15, paciente.getIdPaciente());

        this.execute();
        this.close();

    }

    public void excluir(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String sql = "DELETE FROM paciente where idPaciente = " + id;
        this.prepare(sql);
        this.execute();

        this.close();
    }
    public void ordenarPorNome(String nome) throws SQLException{
        this.setConnection("sal");
        this.open();
        
        String sql = "SELECT nome FROM paciente order by "+nome;
        this.execute();
        this.close();
        
    }
    public void ordenarPorCodigo(int id) throws SQLException{
        this.setConnection("sal");
        this.open();
        
        String sql = "SELECT idPaciente FROM paciente order by "+id;
        this.execute();
        this.close();
        
    }

    public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idPaciente),0)+1 AS ID FROM paciente";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }
}
