/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import salutem.Beans.AgendaConsultaBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class AgendaConsultaDAO extends MySQL{
    
     public void inserir(AgendaConsultaBean agenda) throws SQLException {
        this.setConnection("sal");
        this.open();
        
     
        
        int id = getCodigo();

        String sql = "INSERT INTO agendaconsulta (idAgendaConsulta,idFuncionario,idPaciente"
                + ",data,nomeFuncionario,nomePaciente) values (?,?,?,?,?,?)";
       this.prepare(sql);
       
        
        this.prepare(sql);
        this.setInt(1, id);
        this.setInt(2, agenda.getIdFuncionario());
        this.setInt(3, agenda.getIdPaciente());
        this.setDate(4, agenda.getDate());
        this.setString(5, agenda.getNomeFuncionario());
        this.setString(6, agenda.getNomePaciente());
        
        
        
        this.execute();
        this.close();

    }
    
     public List<AgendaConsultaBean> getLista(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM agendaconsulta WHERE idAgendaConsulta = "+id;
        this.prepare(SQL);
        this.executeQuery();

        List<AgendaConsultaBean> listaEsp = new ArrayList<AgendaConsultaBean>();
        while (this.getRS().next()) {
            AgendaConsultaBean agenda = new AgendaConsultaBean();
            agenda.setIdAgendaConsulta(this.getRS().getInt("idAgendaConsulta"));
            agenda.setDate(this.getRS().getDate("data"));
            agenda.setIdFuncionario(this.getRS().getInt("idFuncionario"));
            agenda.setIdPaciente(this.getRS().getInt("idPaciente"));
            agenda.setNomeFuncionario(this.getRS().getString("nomeFuncionario"));
            agenda.setNomePaciente(this.getRS().getString("nomePaciente"));
           
            listaEsp.add(agenda);
        }

        this.close();

        return listaEsp;
    }
     
      public List<AgendaConsultaBean> getLista(String data) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM agendaconsulta WHERE data = "+data;
        this.prepare(SQL);
        this.executeQuery();

        List<AgendaConsultaBean> listaEsp = new ArrayList<AgendaConsultaBean>();
        while (this.getRS().next()) {
            AgendaConsultaBean agenda = new AgendaConsultaBean();
            agenda.setIdAgendaConsulta(this.getRS().getInt("idAgendaConsulta"));
            agenda.setDate(this.getRS().getDate("data"));
            agenda.setIdFuncionario(this.getRS().getInt("idFuncionario"));
            agenda.setIdPaciente(this.getRS().getInt("idPaciente"));
            agenda.setNomeFuncionario(this.getRS().getString("nomeFuncionario"));
            agenda.setNomePaciente(this.getRS().getString("nomePaciente"));
           
            listaEsp.add(agenda);
        }

        this.close();

        return listaEsp;
    }
     
      public List<AgendaConsultaBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM agendaconsulta";
        this.prepare(SQL);
        this.executeQuery();

        List<AgendaConsultaBean> listaEsp = new ArrayList<AgendaConsultaBean>();
        while (this.getRS().next()) {
            AgendaConsultaBean agenda = new AgendaConsultaBean();
            agenda.setIdAgendaConsulta(this.getRS().getInt("idAgendaConsulta"));
            agenda.setDate(this.getRS().getDate("data"));
            agenda.setIdFuncionario(this.getRS().getInt("idFuncionario"));
            agenda.setIdPaciente(this.getRS().getInt("idPaciente"));
            agenda.setNomeFuncionario(this.getRS().getString("nomeFuncionario"));
            agenda.setNomePaciente(this.getRS().getString("nomePaciente"));
           
            listaEsp.add(agenda);
        }

        this.close();

        return listaEsp;
    }
     
     public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQLi = "SELECT HIGH_PRIORITY IFNULL(MAX(idAgendaConsulta),0)+1 AS ID FROM agendaconsulta";
        this.prepare(SQLi);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }
    
}
