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
public class AgendaConsultaBean {
    private int idAgendaConsulta;
    private String nomeFuncionario;
    private String nomePaciente;
    private int idPaciente;
    private int idFuncionario;
    private Date date;

    /**
     * @return the idAgendaConsulta
     */
    public int getIdAgendaConsulta() {
        return idAgendaConsulta;
    }

    /**
     * @param idAgendaConsulta the idAgendaConsulta to set
     */
    public void setIdAgendaConsulta(int idAgendaConsulta) {
        this.idAgendaConsulta = idAgendaConsulta;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
