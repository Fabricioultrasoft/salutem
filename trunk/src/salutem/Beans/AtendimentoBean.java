/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.Beans;

import java.util.Date;
import javax.xml.soap.Text;

/**
 *
 * @author Tironi
 */
public class AtendimentoBean {
    private int idAtendimento;
    private int idUsuario;
    private int idFuncionario;
    private int idUnidade;
    private Date data;
    private Text descricao;

    /**
     * @return the idAtendimento
     */
    public int getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * @param idAtendimento the idAtendimento to set
     */
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

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
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idUnidade
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the descricao
     */
    public Text getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(Text descricao) {
        this.descricao = descricao;
    }
    
    
    
}
