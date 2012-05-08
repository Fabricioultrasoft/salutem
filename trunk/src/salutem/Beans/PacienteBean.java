/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.Beans;

/**
 *
 * @author Tironi
 */
public class PacienteBean extends PessoaBean {

    private int idPaciente;
    private String nomeMae;
    private String cartaoSus;

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the cartaoSus
     */
    public String getCartaoSus() {
        return cartaoSus;
    }

    /**
     * @param cartaoSus the cartaoSus to set
     */
    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
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
    
}
