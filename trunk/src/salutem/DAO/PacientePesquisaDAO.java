/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.PacienteBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class PacientePesquisaDAO extends MySQL {
    
    public List<PacienteBean> getLista(String filtro) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM paciente WHERE nome LIKE '%"+filtro+"%'";
        this.prepare(SQL);
        this.executeQuery();

        List<PacienteBean> listaEsp = new ArrayList<PacienteBean>();
        while (this.getRS().next()) {
            PacienteBean paciente = new PacienteBean();
            paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
            paciente.setNome(this.getRS().getString("nome"));
           
            listaEsp.add(paciente);
        }

        this.close();

        return listaEsp;
    }
    
    public List<PacienteBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM paciente";
        this.prepare(SQL);
        this.executeQuery();

        List<PacienteBean> listaEsp = new ArrayList<PacienteBean>();
        while (this.getRS().next()) {
            PacienteBean paciente = new PacienteBean();
            paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
            paciente.setNome(this.getRS().getString("nome"));
            
            
            listaEsp.add(paciente);
        }

        this.close();

        return listaEsp;
    }
    
}
