/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.Beans;

import java.util.Date;
import java.util.List;

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
    private List<EspecialidadeBean> especialidade;
    private List<CargoBean> cargo;
    private List<UnidadeBean> unidade;

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

    /**
     * @return the especialidade
     */
    public List<EspecialidadeBean> getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(List<EspecialidadeBean> especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the cargo
     */
    public List<CargoBean> getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(List<CargoBean> cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the unidade
     */
    public List<UnidadeBean> getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(List<UnidadeBean> unidade) {
        this.unidade = unidade;
    }
}
