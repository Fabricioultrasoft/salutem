/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.Beans;

import java.util.List;

/**
 *
 * @author Renato Doretto
 */
public class UsuarioBean {

    private int idUsuario;
    private String login;
    private String senha;
    private FuncionarioBean funcionario;
    private List<PermissaoBean> permissao;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the funcionario
     */
    public FuncionarioBean getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(FuncionarioBean funcionario) {
        this.funcionario = funcionario;
    }

}
