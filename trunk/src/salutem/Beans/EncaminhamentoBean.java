/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.Beans;

/**
 *
 * @author Tironi
 */
public class EncaminhamentoBean {
    private int idEncaminhamento;
    private int idPaciente;
    private int idEspecialidade;
    private int idFuncionario;
    private String descricao;

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
    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    /**
     * @param idEspecialidade the idEspecialidade to set
     */
    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
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
    
}
