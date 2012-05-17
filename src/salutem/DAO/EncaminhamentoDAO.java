/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import salutem.Beans.EncaminhamentoBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Tironi
 */
public class EncaminhamentoDAO extends MySQL{
    
     public void inserir(EncaminhamentoBean enca) throws SQLException {
        this.setConnection("sal");
        this.open();
        
        
        
        int id = getCodigo();

        String sql = "INSERT INTO encaminhamento (idEncaminhamento,idAtendimento,nomeEspecialidade,descricao,data,nomePaciente) values (?,?,?,?,?,?)";
       
        
       
        
         this.prepare(sql);
        this.setInt(1, id);
        this.setInt(2, enca.getIdAtendimento());
        this.setString(3, enca.getNomeEspecialidade());
        this.setString(4, enca.getDescricao());
        this.setDate(5, enca.getData());
        this.setString(6, enca.getNomePaciente());
        
        
        this.execute();
        this.close();

    }
     
     public int getCodigo() throws SQLException {
        //this.setConnection("sal");
        //this.open();

        String SQLi = "SELECT HIGH_PRIORITY IFNULL(MAX(idEncaminhamento),0)+1 AS ID FROM encaminhamento";
        this.prepare(SQLi);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        //this.close();

        return novoId;
    }
    
}
