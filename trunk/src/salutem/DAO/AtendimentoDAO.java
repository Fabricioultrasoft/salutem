/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.soap.Text;
import salutem.Beans.AtendimentoBean;
import salutem.Beans.PacienteBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class AtendimentoDAO extends MySQL{
    
    public void inserir(AtendimentoBean atendimento) throws SQLException {
        this.setConnection("sal");
        this.open();
        
     
        
        int id = getCodigo();

        String sql = "INSERT INTO atendimento (idAtendimento,data,descricao,idUsuario,idUnidade,idPaciente"+
                      ") values (?,?,?,?,?,?)";
       
        
        this.prepare(sql);
        
        this.prepare(sql);
        this.setInt(1, id);
        this.setDate(2, atendimento.getData());
        this.setString(3, atendimento.getDescricao());
        this.setInt(4, atendimento.getIdUsuario());
        this.setInt(5, atendimento.getIdUnidade());
        this.setInt(6, atendimento.getIdPaciente());
        
        
        
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
            paciente.setData((Date)this.getRS().getDate("data"));
            
           
            
            lista.add(paciente);
        }

        this.close();

        return lista;
    }
    
    public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQLi = "SELECT HIGH_PRIORITY IFNULL(MAX(idPaciente),0)+1 AS ID FROM paciente";
        this.prepare(SQLi);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }

   
  
    
}
