/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.Beans;

/**
 *
 * @author Tironi
 */
public class PreAtendimentoBean {
    private int idPreAtendimento;
    private int idPaciente;
    private int temperatura;
    private int pressaoArterial;

    /**
     * @return the idPreAtendimento
     */
    public int getIdPreAtendimento() {
        return idPreAtendimento;
    }

    /**
     * @param idPreAtendimento the idPreAtendimento to set
     */
    public void setIdPreAtendimento(int idPreAtendimento) {
        this.idPreAtendimento = idPreAtendimento;
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
     * @return the temperatura
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the pressaoArterial
     */
    public int getPressaoArterial() {
        return pressaoArterial;
    }

    /**
     * @param pressaoArterial the pressaoArterial to set
     */
    public void setPressaoArterial(int pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }
    
}
