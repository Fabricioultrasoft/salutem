package salutem.Beans;

/**
 *
 * @author Sandro Alves Peres
 */
public class PermissaoBean {

    private FuncionarioBean funcionario;
    private ModuloBean modulo;

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

    /**
     * @return the modulo
     */
    public ModuloBean getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(ModuloBean modulo) {
        this.modulo = modulo;
    }
}
