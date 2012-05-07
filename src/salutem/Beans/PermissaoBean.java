package salutem.Beans;

/**
 *
 * @author Renato Doretto
 */
public class PermissaoBean {

    private UsuarioBean usuario;
    private ModuloBean modulo;

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

    /**
     * @return the usuario
     */
    public UsuarioBean getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
}
