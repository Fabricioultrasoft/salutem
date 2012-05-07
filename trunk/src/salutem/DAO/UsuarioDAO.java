/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.FuncionarioBean;
import salutem.Beans.ModuloBean;
import salutem.Beans.PermissaoBean;
import salutem.Beans.UsuarioBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class UsuarioDAO extends MySQL{

    public void inserir(UsuarioBean usuario) throws SQLException{
        this.setConnection("sal");
        this.open();
        
        String SQL = "INSERT INTO usuario (idUsuario, login, senha, idFuncionario) VALUES (?,?,?,PASSWORD(MD5(?)))";
        this.prepare(SQL);
        this.setInt(1, this.getCodigo());
        this.setString(2, usuario.getLogin());
        this.setString(3, usuario.getSenha());
        this.setInt(4, usuario.getFuncionario().getIdFuncionario());
        this.execute();

        this.close();

    }

    private void inserirPermissao(int idUsuario, PermissaoBean permissao) throws SQLException {
        String SQL = "REPLACE INTO permissao (idFuncionario, idModulo) VALUES (?, ?)";
        this.prepare(SQL);
        this.setInt(1, idUsuario);
        this.setInt(2, permissao.getModulo().getIdModulo());
        this.execute();
    }

    private void excluirPermissoes(int idUsuario) throws SQLException {
        String SQL = "DELETE FROM permissao WHERE permissao.idFuncionario = " + idUsuario;
        this.prepare(SQL);
        this.execute();
    }

    public void excluir(int id) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM usuario WHERE idUsuario = "+id;
        this.prepare(SQL);
        this.execute();

        this.close();
    }

    public void alterarSenha(int idUsuario, String senha) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "UPDATE usuario SET senha = PASSWORD(MD5('"+senha+"')) WHERE idUsuario = "+idUsuario;
        this.prepare(SQL);
        this.execute();

        this.close();
    }

    public boolean validarSenha(int idUsuario, String senha) throws SQLException {
        this.setConnection("soft-academico");
        this.open();

        String SQL = "SELECT STRCMP(senha, PASSWORD(MD5('"+senha+"'))) AS RS FROM usuario "
                + "WHERE idUsuario = "+idUsuario;
        this.prepare(SQL);
        this.executeQuery();

        this.getRS().first();
        int RS = this.getRS().getInt("RS");

        this.close();

        return (RS == 0 ? true : false);
    }

    public UsuarioBean getUsuario(String login, String senha) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT u.*, f.* "
                + "FROM usuario u, funcionario f "
                + "WHERE u.idFuncionario = f.idFuncionario "
                + "AND u.login = '"+login+"' "
                + "AND u.senha = PASSWORD (MD5('"+senha+"'))";
        this.prepare(SQL);
        this.executeQuery();

        this.getRS().first();

        MySQL conAux = new MySQL("sal", true);

        int idUsuario = this.getRS().getInt("idUsuario");

        String auxSQL = "SELECT p.*, m.*"
                + "FROM permissao p, modulo m "
                + "WHERE p.idModulo = m.idModulo "
                + "AND p.idUsuario = "+idUsuario;
        conAux.prepare(auxSQL);
        conAux.executeQuery();

        List<PermissaoBean> listaPermissoes = new ArrayList<PermissaoBean>();
        while(conAux.getRS().next()){
            ModuloBean modulo = new ModuloBean();
            modulo.setIdModulo(conAux.getRS().getInt("idModulo"));
            modulo.setDescricao(conAux.getRS().getString("descricao"));
            modulo.setModuloPai(null);

            PermissaoBean permissao = new PermissaoBean();
            permissao.setModulo(modulo);
            listaPermissoes.add(permissao);
        }
        
        FuncionarioBean funcionario = new FuncionarioBean();
        funcionario.setIdFuncionario(this.getRS().getInt("idFuncionario"));
        funcionario.setNome(this.getRS().getString("nome"));
        funcionario.setCpfCnpj(this.getRS().getString("cpf"));
        funcionario.setRgie(this.getRS().getString("rg"));
        funcionario.setAdmissao(this.getRS().getDate("admissao"));
        funcionario.setDecreto(this.getRS().getString("decreto"));
        funcionario.setTipoRegistro(this.getRS().getString("tipoRegistro"));
        funcionario.setRegistro(this.getRS().getString("registro"));
        funcionario.setTelefone(this.getRS().getString("telefone"));
        funcionario.setRua(this.getRS().getString("rua"));
        funcionario.setNumero(this.getRS().getInt("numero"));
        funcionario.setBairro(this.getRS().getString("bairro"));
        funcionario.setComplemento(this.getRS().getString("complemento"));
        funcionario.setCidade(this.getRS().getString("cidade"));
        funcionario.setEstado(this.getRS().getString("estado"));
        funcionario.setSexo(this.getRS().getString("sexo"));

        UsuarioBean usuario = new UsuarioBean();
        usuario.setIdUsuario(this.getRS().getInt("idUsuario"));
        usuario.setLogin(this.getRS().getString("login"));
        usuario.setSenha(null);
        usuario.setFuncionario(funcionario);

        conAux.close();
        this.close();

        return usuario;
    }

    public void logar(String login, String senha) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT COUNT(*) AS TOTAL FROM usuario "
                + "WHERE login = '" + login + "' AND "
                + "senha = PASSWORD(MD5('" + senha + "'))";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        if (getRS().getInt("TOTAL") == 0) {
            this.close();
            throw new SQLException("USUARIO-INVALIDO");
        }

        this.close();
    }

    public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idUsuario),0)+1 AS ID FROM usuario";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }

}
