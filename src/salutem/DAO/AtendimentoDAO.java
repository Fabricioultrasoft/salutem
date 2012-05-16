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

        String sql = "INSERT INTO atendimento (idAtendimento,data,descricao,idUsuario,idUnidade,"+
                       "idPaciente,medicamento,temperatura,alta,baixa,diagnostico"+
                      ") values (?,?,?,?,?,?,?,?,?,?,?)";
       this.prepare(sql);
       
        
        this.prepare(sql);
        this.setInt(1, id);
        this.setDate(2, atendimento.getData());
        this.setString(3, atendimento.getDescricao());
        this.setInt(4, atendimento.getIdUsuario());
        this.setInt(5, atendimento.getIdUnidade());
        this.setInt(6, atendimento.getIdPaciente());
        this.setString(7, atendimento.getMedicamento());
        this.setInt(8, atendimento.getTemperatura());
        this.setInt(9, atendimento.getAlta());
        this.setInt(10, atendimento.getBaixa());
        this.setString(11, atendimento.getDiagnostico());
        
        
        
        this.execute();
        this.close();

    }
    
         public List<AtendimentoBean> getLista(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM atendimento WHERE idPaciente = "+id;
        this.prepare(SQL);
        this.executeQuery();

        List<AtendimentoBean> listaEsp = new ArrayList<AtendimentoBean>();
        while (this.getRS().next()) {
            AtendimentoBean paciente = new AtendimentoBean();
            paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
            paciente.setAlta(this.getRS().getInt("alta"));
            paciente.setBaixa(this.getRS().getInt("baixa"));
            paciente.setData(this.getRS().getDate("data"));
            paciente.setDescricao(this.getRS().getString("descricao"));
            paciente.setMedicamento(this.getRS().getString("medicamento"));
            paciente.setDiagnostico(this.getRS().getString("diagnostico"));
            paciente.setTemperatura(this.getRS().getInt("temperatura"));
            
           
            listaEsp.add(paciente);
        }

        this.close();

        return listaEsp;
    }
    
       public List<AtendimentoBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM atendimento";
        this.prepare(SQL);
        this.executeQuery();

        List<AtendimentoBean> listaEsp = new ArrayList<AtendimentoBean>();
        while (this.getRS().next()) {
            AtendimentoBean paciente = new AtendimentoBean();
            paciente.setIdPaciente(this.getRS().getInt("idPaciente"));
            paciente.setAlta(this.getRS().getInt("alta"));
            paciente.setBaixa(this.getRS().getInt("baixa"));
            paciente.setData(this.getRS().getDate("data"));
            paciente.setDescricao(this.getRS().getString("descricao"));
            paciente.setMedicamento(this.getRS().getString("medicamento"));
            
            
            listaEsp.add(paciente);
        }

        this.close();

        return listaEsp;
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

        String SQLi = "SELECT HIGH_PRIORITY IFNULL(MAX(idAtendimento),0)+1 AS ID FROM atendimento";
        this.prepare(SQLi);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }

   public AtendimentoBean getPaciente(int id)throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM atendimento WHERE idAtendimento = "+id;
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();
        AtendimentoBean atend = new AtendimentoBean();
        atend.setIdAtendimento(this.getRS().getInt("idPaciente"));
        atend.setDescricao(this.getRS().getString("descricao"));
        atend.setMedicamento(this.getRS().getString("medicamento"));
       

        this.close();
        return atend;

    }
  
    
}
