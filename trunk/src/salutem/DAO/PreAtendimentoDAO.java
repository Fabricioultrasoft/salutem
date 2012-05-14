/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import salutem.Beans.PacienteBean;
import salutem.Beans.PreAtendimentoBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class PreAtendimentoDAO extends MySQL{
    private int idC;
    
    public void inserir(PreAtendimentoBean atendimento) throws SQLException {
        this.setConnection("sal");
        this.open();
        
     
        
        idC = getCodigo();

        String sql = "INSERT INTO preatendimento (idPreAtendimento,idPaciente,temperatura,alta,baixa)"+
                " values(?,?,?,?,?)";
       this.prepare(sql);
       
        
        this.prepare(sql);
        this.setInt(1, idC);
        this.setInt(2, atendimento.getIdPaciente());
        this.setInt(3, atendimento.getTemperatura());
        this.setInt(4, atendimento.getAlta());
        this.setInt(5, atendimento.getBaixa());
        
        
        
        this.execute();
        this.close();

    }
    
    public List<PacienteBean> getListaPaciente() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM paciente";
        this.prepare(SQL);
        this.executeQuery();

        List<PacienteBean> lista = new ArrayList<PacienteBean>();
        while (this.getRS().next()) {
            PacienteBean paciente = new PacienteBean();
            paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
            paciente.setNome(this.getRS().getString("nome"));
            
            
           
            
            lista.add(paciente);
        }

        this.close();

        return lista;
    }
    
     public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQLi = "SELECT HIGH_PRIORITY IFNULL(MAX(idPreAtendimento),0)+1 AS ID FROM preatendimento";
        this.prepare(SQLi);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    
     }
     
     public PreAtendimentoBean getPreAtendimento(int id)throws SQLException{
        this.setConnection("sal");
        this.open();
        PreAtendimentoBean paciente = new PreAtendimentoBean();
        
        
        
        

        String SQL = "SELECT * FROM preatendimento WHERE idPaciente = "+id+"AND idPreAtendimento = "+this.idC;
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();
       
        
        paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
        paciente.setTemperatura(this.getRS().getInt("temperatura"));
        paciente.setAlta(this.getRS().getInt("alta"));
        paciente.setBaixa(this.getRS().getInt("baixa"));
        paciente.setIdPreAtendimento(this.getRS().getInt("idPreAtendimento"));
        

        this.close();
        return paciente;

    }
     
    
}