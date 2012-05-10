/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.DAO;

import java.sql.SQLException;
import java.util.List;
import salutem.Beans.FuncionarioBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class FuncionarioDAO extends MySQL{

    public void inserir(FuncionarioBean func) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT COUNT(*) AS T FROM funcionario "
                + "WHERE funcionario.cpf = ?";
        this.prepare(SQL);
        this.setString(1, func.getCpfCnpj());
        this.executeQuery();
        this.getRS().first();

        if (this.getRS().getInt("T") > 0) {
            this.close();
            throw new SQLException("CPF-DUPLICADO");
        }

        SQL = "INSERT INTO funcionario (idFuncionario, nome, cpf, rg, "
                + "admissao, decreto, registro, telefone, celular, rua, complemento, "
                + "bairro, numero, cidade, estado, tipoRegistro, sexo, dtNascimento) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        this.prepare(SQL);
        this.setInt(1, this.getCodigo());
        this.setString(2, func.getNome());
        this.setString(3, func.getCpfCnpj());
        this.setString(4, func.getRgie());
        this.setDate(5, func.getAdmissao());
        this.setInt(6, func.getDecreto());
        this.setString(7, func.getRegistro());
        this.setString(8, func.getTelefone());
        this.setString(9, func.getCelular());
        this.setString(10, func.getRua());
        this.setString(11, func.getComplemento());
        this.setString(12, func.getBairro());
        this.setInt(13, func.getNumero());
        this.setString(14, func.getCidade());
        this.setString(15, func.getEstado());
        this.setString(16, func.getTipoRegistro());
        this.setString(17, func.getSexo());
        this.setDate(18, func.getData());
        this.execute();

        this.close();
    }

    public void alterar(FuncionarioBean func) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT COUNT(*) AS T FROM funcionario "
                + "WHERE funcionario.cpf = ? AND funcionario.idFuncionario <> ?";
        this.prepare(SQL);
        this.setString(1, func.getCpfCnpj());
        this.setInt(2, func.getIdFuncionario());
        this.executeQuery();
        this.getRS().first();

        if (this.getRS().getInt("T") > 0) {
            this.close();
            throw new SQLException("CPF-DUPLICADO");
        }

       SQL = "UPDATE funcionario SET nome = ?, cpf = ?, rg = ?, admissao = ?, "
                + "decreto = ?, registro = ?, telefone = ?, celular = ?, rua = ?, "
                + "complemento = ?, bairro = ?, numero = ?, cidade = ?, estado = ?, "
                + "tipoRegistro = ?, sexo = ?, dtNascimento = ? WHERE idFuncionario = ?";

        this.prepare(SQL);
        this.setString(1, func.getNome());
        this.setString(2, func.getCpfCnpj());
        this.setString(3, func.getRgie());
        this.setDate(4, func.getAdmissao());
        this.setInt(5, func.getDecreto());
        this.setString(6, func.getRegistro());
        this.setString(7, func.getTelefone());
        this.setString(8, func.getCelular());
        this.setString(8, func.getRua());
        this.setString(10, func.getComplemento());
        this.setString(11, func.getBairro());
        this.setInt(12, func.getNumero());
        this.setString(13, func.getCidade());
        this.setString(14, func.getEstado());
        this.setString(15, func.getTipoRegistro());
        this.setString(16, func.getSexo());
        this.setDate(17, func.getData());
        this.setInt(18, func.getIdFuncionario());
        this.execute();

        this.close();
    }

    public void excluir(int id) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM funcionario WHERE idFuncinario = "+id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

//    public List<FuncionarioBean> getLista() throws SQLException{
//        this.setConnection("sal");
//        this.open();
//
//        String SQL = "SELECT * FROM funcionario f, especialidade e, cargo c "
//                + "WHERE e.idFuncionadio";
//    }

    public int getCodigo() throws SQLException {
        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idFuncionario),0)+1 AS ID FROM funcionario";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");


        return novoId;
    }

}
