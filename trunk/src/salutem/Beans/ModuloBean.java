package salutem.Beans;

/**
 * 
 * @author Renato Doretto
 */
public class ModuloBean {

    private int idModulo;
    private ModuloBean moduloPai;
    private String descricao;

    /**
     * @return the idModulo
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * @return the moduloPai
     */
    public ModuloBean getModuloPai() {
        return moduloPai;
    }

    /**
     * @param moduloPai the moduloPai to set
     */
    public void setModuloPai(ModuloBean moduloPai) {
        this.moduloPai = moduloPai;
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