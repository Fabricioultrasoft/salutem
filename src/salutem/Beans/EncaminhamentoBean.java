/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.Beans;

import java.util.Date;

/**
 *
 * @author Tironi
 */
public class EncaminhamentoBean {
    private int idEncaminhamento;
    private int idPaciente;
    private String nomeEspecialidade;
    private int idFuncionario;
    private int idAtendimento;
    private String descricao;
    private Date data;
    private String nomePaciente;

    /**
     * @return the idEncaminhamento
     */
    public int getIdEncaminhamento() {
        return idEncaminhamento;
    }

    /**
     * @param idEncaminhamento the idEncaminhamento to set
     */
    public void setIdEncaminhamento(int idEncaminhamento) {
        this.idEncaminhamento = idEncaminhamento;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the idEspecialidade
     */
    
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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
     * @return the nomeEspecialidade
     */
    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    /**
     * @param nomeEspecialidade the nomeEspecialidade to set
     */
    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    /**
     * @return the nomePaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomePaciente the nomePaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    
}
