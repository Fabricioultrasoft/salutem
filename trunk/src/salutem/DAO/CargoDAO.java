/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.CargoBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class CargoDAO extends MySQL{

    public void inserir(CargoBean cargo) throws SQLException{
        this.setConnection("sal");
        this.open();

        int id = this.getCodigo();

        String SQL = "INSERT INTO cargo (idCargo, descricao) "
                + "VALUES (?,?)";
        this.prepare(SQL);
        this.setInt(1, id);
        this.setString(2, cargo.getDescricao());
        this.execute();
        this.close();
    }

    public void alterar(CargoBean cargo) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "UPDATE cargo SET descricao = ? WHERE idCargo = ?";
        this.prepare(SQL);
        this.setString(1, cargo.getDescricao());
        this.setInt(2, cargo.getIdCargo());
        this.execute();
        this.close();
    }

    public void excluir(int id) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM cargo WHERE idCargo = "+id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public List<CargoBean> getLista() throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM cargo";
        this.prepare(SQL);
        this.executeQuery();

        List<CargoBean> listaCargo = new ArrayList<CargoBean>();
        while(this.getRS().next()){
            CargoBean cargo = new CargoBean();
            cargo.setIdCargo(this.getRS().getInt("idCargo"));
            cargo.setDescricao(this.getRS().getString("descricao"));
            listaCargo.add(cargo);
        }

        this.close();

        return listaCargo;
    }

    public List<CargoBean> getLista(String filtro) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM cargo WHERE descricao LIKE '%"+filtro+"%'";
        this.prepare(SQL);
        this.executeQuery();

        List<CargoBean> listaCargo = new ArrayList<CargoBean>();
        while(this.getRS().next()){
            CargoBean cargo = new CargoBean();
            cargo.setIdCargo(this.getRS().getInt("idCargo"));
            cargo.setDescricao(this.getRS().getString("descricao"));
            listaCargo.add(cargo);
        }

        this.close();

        return listaCargo;
    }

    public CargoBean getCargo(int id) throws SQLException{
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM cargo WHERE idCargo = "+id;
        this.prepare(SQL);
        this.executeQuery();

        this.getRS().first();
        CargoBean cargo = new CargoBean();
        cargo.setIdCargo(id);
        cargo.setDescricao(this.getRS().getString("descricao"));

        this.close();

        return cargo;
    }

    public int getCodigo() throws SQLException {
        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idCargo),0)+1 AS ID FROM cargo";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");

        return novoId;
    }
}
