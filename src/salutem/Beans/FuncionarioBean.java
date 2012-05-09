/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.Beans;

import java.util.Date;

/**
 *
 * @author Renato Doretto
 */
public class FuncionarioBean extends PessoaBean{

    private int idFuncionario;
    private Date admissao;
    private int decreto;
    private String tipoRegistro;
    private String registro;

    /**
     * @return the admissao
     */
    public Date getAdmissao() {
        return admissao;
    }

    /**
     * @param admissao the admissao to set
     */
    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    /**
     * @return the decreto
     */
    public int getDecreto() {
        return decreto;
    }

    /**
     * @param decreto the decreto to set
     */
    public void setDecreto(int decreto) {
        this.decreto = decreto;
    }

    /**
     * @return the tipoRegistro
     */
    public String getTipoRegistro() {
        return tipoRegistro;
    }

    /**
     * @param tipoRegistro the tipoRegistro to set
     */
    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
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
}
