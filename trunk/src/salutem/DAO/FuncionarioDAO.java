/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salutem.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import salutem.Beans.CargoBean;
import salutem.Beans.EspecialidadeBean;
import salutem.Beans.FuncionarioBean;
import salutem.Beans.UnidadeBean;
import salutem.conexao.MySQL;

/**
 *
 * @author Renato Doretto
 */
public class FuncionarioDAO extends MySQL {

    public void inserir(FuncionarioBean func) throws SQLException {
        this.setConnection("sal");
        this.open();

        int id = this.getCodigo();

        String SQL = "SELECT COUNT(*) AS T FROM funcionario "
                + "WHERE funcionario.cpf = ?";
        this.prepare(SQL);
        this.setString(1, func.getCpfCnpj());
        this.executeQuery();
        this.getRS().first();

        if (this.getRS().getInt("T") > 0) {
            this.close();
            throw new SQLException("CPF-DUPLICADO");
        }

        SQL = "INSERT INTO funcionario (idFuncionario, nome, cpf, rg, "
                + "admissao, decreto, registro, telefone, celular, rua, complemento, "
                + "bairro, numero, cidade, estado, tipoRegistro, sexo, dtNascimento) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        this.prepare(SQL);
        this.setInt(1, id);
        this.setString(2, func.getNome());
        this.setString(3, func.getCpfCnpj());
        this.setString(4, func.getRgie());
        this.setDate(5, func.getAdmissao());
        this.setInt(6, func.getDecreto());
        this.setString(7, func.getRegistro());
        this.setString(8, func.getTelefone());
        this.setString(9, func.getCelular());
        this.setString(10, func.getRua());
        this.setString(11, func.getComplemento());
        this.setString(12, func.getBairro());
        this.setInt(13, func.getNumero());
        this.setString(14, func.getCidade());
        this.setString(15, func.getEstado());
        this.setString(16, func.getTipoRegistro());
        this.setString(17, func.getSexo());
        this.setDate(18, func.getData());
        this.execute();

        for (int i = 0; i < func.getUnidade().size(); i++) {
            this.inserirUnidade(id, func.getUnidade().get(i).getIdUnidade());
        }

        for (int i = 0; i < func.getCargo().size(); i++) {
            this.inserirCargo(id, func.getCargo().get(i).getIdCargo());
        }

        for (int i = 0; i < func.getEspecialidade().size(); i++) {
            this.inserirEspecialidade(id, func.getEspecialidade().get(i).getIdEspecialidade());

        }

        this.close();
    }

    public void alterar(FuncionarioBean func) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT COUNT(*) AS T FROM funcionario "
                + "WHERE funcionario.cpf = ? AND funcionario.idFuncionario <> ?";
        this.prepare(SQL);
        this.setString(1, func.getCpfCnpj());
        this.setInt(2, func.getIdFuncionario());
        this.executeQuery();
        this.getRS().first();

        if (this.getRS().getInt("T") > 0) {
            this.close();
            throw new SQLException("CPF-DUPLICADO");
        }

        SQL = "UPDATE funcionario SET nome = ?, cpf = ?, rg = ?, admissao = ?, "
                + "decreto = ?, registro = ?, telefone = ?, celular = ?, rua = ?, "
                + "complemento = ?, bairro = ?, numero = ?, cidade = ?, estado = ?, "
                + "tipoRegistro = ?, sexo = ?, dtNascimento = ? WHERE idFuncionario = ?";

        this.prepare(SQL);
        this.setString(1, func.getNome());
        this.setString(2, func.getCpfCnpj());
        this.setString(3, func.getRgie());
        this.setDate(4, func.getAdmissao());
        this.setInt(5, func.getDecreto());
        this.setString(6, func.getRegistro());
        this.setString(7, func.getTelefone());
        this.setString(8, func.getCelular());
        this.setString(8, func.getRua());
        this.setString(10, func.getComplemento());
        this.setString(11, func.getBairro());
        this.setInt(12, func.getNumero());
        this.setString(13, func.getCidade());
        this.setString(14, func.getEstado());
        this.setString(15, func.getTipoRegistro());
        this.setString(16, func.getSexo());
        this.setDate(17, func.getData());
        this.setInt(18, func.getIdFuncionario());
        this.execute();

        this.excluirUnidade(func.getIdFuncionario());
        this.excluirEspecialidade(func.getIdFuncionario());
        this.excluirCargo(func.getIdFuncionario());

        for (int i = 0; i < func.getUnidade().size(); i++) {
            this.inserirUnidade(func.getIdFuncionario(), func.getUnidade().get(i).getIdUnidade());
        }

        for (int i = 0; i < func.getCargo().size(); i++) {
            this.inserirCargo(func.getIdFuncionario(), func.getCargo().get(i).getIdCargo());
        }

        for (int i = 0; i < func.getEspecialidade().size(); i++) {
            this.inserirEspecialidade(func.getIdFuncionario(), func.getEspecialidade().get(i).getIdEspecialidade());

        }

        this.close();
    }

    public void excluir(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "DELETE FROM funcionario WHERE idFuncinario = " + id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public List<FuncionarioBean> getLista() throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM funcionario";
        this.prepare(SQL);
        this.executeQuery();

        MySQL conAux = new MySQL("sal", true);

        List<FuncionarioBean> listaFunc = new ArrayList<FuncionarioBean>();
        while (this.getRS().next()) {
            int idFunc = this.getRS().getInt("idFuncionario");

            String SQLaux = "SELECT e.idEspecialidade, e.nome AS nomeEsp "
                    + "FROM especialidade e, especialidadeFuncionario ef"
                    + "WHERE ef.idEspecialidade = e.idEspecialidade "
                    + "AND ef.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<EspecialidadeBean> listaEsp = new ArrayList<EspecialidadeBean>();
            while (conAux.getRS().next()) {
                EspecialidadeBean esp = new EspecialidadeBean();
                esp.setIdEspecialidade(conAux.getRS().getInt("idEspecialidade"));
                esp.setNome(conAux.getRS().getString("nomeEsp"));
                listaEsp.add(esp);
            }

            SQLaux = "SELECT c.* FROM cargo c, cargoFuncionario cf "
                    + "WHERE c.idCargo = cf.idCargo "
                    + "AND cf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<CargoBean> listaCargo = new ArrayList<CargoBean>();
            while (conAux.getRS().next()) {
                CargoBean cargo = new CargoBean();
                cargo.setIdCargo(conAux.getRS().getInt("idCargo"));
                cargo.setDescricao(conAux.getRS().getString("descricao"));
                listaCargo.add(cargo);
            }

            SQLaux = "SELECT u.idUnidade u.nome AS nomeU, u.rua AS ruaU, u.numero AS numeroU, "
                    + "u.bairro AS bairroU, u.complemento AS compU "
                    + "FROM unidade u, unidadeFuncionario uf "
                    + "WHERE u.idUnidade = uf.idUnidade "
                    + "AND uf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<UnidadeBean> listaUn = new ArrayList<UnidadeBean>();
            while (conAux.getRS().next()) {
                UnidadeBean unidade = new UnidadeBean();
                unidade.setIdUnidade(conAux.getRS().getInt("idUnidade"));
                unidade.setNome(conAux.getRS().getString("nomeU"));
                unidade.setRua(conAux.getRS().getString("ruaU"));
                unidade.setNumero(conAux.getRS().getInt("numeroU"));
                unidade.setBairro(conAux.getRS().getString("bairroU"));
                unidade.setComplemento(conAux.getRS().getString("compU"));
                listaUn.add(unidade);
            }

            FuncionarioBean func = new FuncionarioBean();
            func.setIdFuncionario(idFunc);
            func.setNome(this.getRS().getString("nome"));
            func.setCpfCnpj(this.getRS().getString("cpf"));
            func.setRgie(this.getRS().getString("rg"));
            func.setSexo(this.getRS().getString("sexo"));
            func.setTelefone(this.getRS().getString("telefone"));
            func.setCelular(this.getRS().getString("celular"));
            func.setRua(this.getRS().getString("rua"));
            func.setNumero(this.getRS().getInt("numero"));
            func.setComplemento(this.getRS().getString("complemento"));
            func.setBairro(this.getRS().getString("bairro"));
            func.setEstado(this.getRS().getString("estado"));
            func.setCidade(this.getRS().getString("cidade"));
            func.setAdmissao(this.getRS().getDate("admissao"));
            func.setDecreto(this.getRS().getInt("decreto"));
            func.setData(this.getRS().getDate("dtNascimento"));
            func.setRegistro(this.getRS().getString("registro"));
            func.setTipoRegistro(this.getRS().getString("tipoRegistro"));
            func.setUnidade(listaUn);
            func.setEspecialidade(listaEsp);
            func.setCargo(listaCargo);
            listaFunc.add(func);
        }

        conAux.close();
        this.close();

        return listaFunc;
    }

    public List<FuncionarioBean> getLista(String filtro) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM funcionario WHERE nome LIKE '%"+filtro+"%'";
        this.prepare(SQL);
        this.executeQuery();

        MySQL conAux = new MySQL("sal", true);

        List<FuncionarioBean> listaFunc = new ArrayList<FuncionarioBean>();
        while (this.getRS().next()) {
            int idFunc = this.getRS().getInt("idFuncionario");

            String SQLaux = "SELECT e.idEspecialidade, e.nome AS nomeEsp "
                    + "FROM especiialidade e, especialidadeFuncionario ef"
                    + "WHERE ef.idEspecialidade = e.idEspecialidade "
                    + "AND ef.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<EspecialidadeBean> listaEsp = new ArrayList<EspecialidadeBean>();
            while (conAux.getRS().next()) {
                EspecialidadeBean esp = new EspecialidadeBean();
                esp.setIdEspecialidade(conAux.getRS().getInt("idEspecialidade"));
                esp.setNome(conAux.getRS().getString("nomeEsp"));
                listaEsp.add(esp);
            }

            SQLaux = "SELECT c.* FROM cargo c, cargoFuncionario cf "
                    + "WHERE c.idCargo = cf.idCargo "
                    + "AND cf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<CargoBean> listaCargo = new ArrayList<CargoBean>();
            while (conAux.getRS().next()) {
                CargoBean cargo = new CargoBean();
                cargo.setIdCargo(conAux.getRS().getInt("idCargo"));
                cargo.setDescricao(conAux.getRS().getString("descricao"));
                listaCargo.add(cargo);
            }

            SQLaux = "SELECT u.idUnidade u.nome AS nomeU, u.rua AS ruaU, u.numero AS numeroU, "
                    + "u.bairro AS bairroU, u.complemento AS compU "
                    + "FROM unidade u, unidadeFuncionario uf "
                    + "WHERE u.idUnidade = uf.idUnidade "
                    + "AND uf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<UnidadeBean> listaUn = new ArrayList<UnidadeBean>();
            while (conAux.getRS().next()) {
                UnidadeBean unidade = new UnidadeBean();
                unidade.setIdUnidade(conAux.getRS().getInt("idUnidade"));
                unidade.setNome(conAux.getRS().getString("nomeU"));
                unidade.setRua(conAux.getRS().getString("ruaU"));
                unidade.setNumero(conAux.getRS().getInt("numeroU"));
                unidade.setBairro(conAux.getRS().getString("bairroU"));
                unidade.setComplemento(conAux.getRS().getString("compU"));
                listaUn.add(unidade);
            }

            FuncionarioBean func = new FuncionarioBean();
            func.setIdFuncionario(idFunc);
            func.setNome(this.getRS().getString("nome"));
            func.setCpfCnpj(this.getRS().getString("cpf"));
            func.setRgie(this.getRS().getString("rg"));
            func.setSexo(this.getRS().getString("sexo"));
            func.setTelefone(this.getRS().getString("telefone"));
            func.setCelular(this.getRS().getString("celular"));
            func.setRua(this.getRS().getString("rua"));
            func.setNumero(this.getRS().getInt("numero"));
            func.setComplemento(this.getRS().getString("complemento"));
            func.setBairro(this.getRS().getString("bairro"));
            func.setEstado(this.getRS().getString("estado"));
            func.setCidade(this.getRS().getString("cidade"));
            func.setAdmissao(this.getRS().getDate("admissao"));
            func.setDecreto(this.getRS().getInt("decreto"));
            func.setData(this.getRS().getDate("dtNascimento"));
            func.setRegistro(this.getRS().getString("registro"));
            func.setTipoRegistro(this.getRS().getString("tipoRegistro"));
            func.setUnidade(listaUn);
            func.setEspecialidade(listaEsp);
            func.setCargo(listaCargo);
            listaFunc.add(func);
        }

        conAux.close();
        this.close();

        return listaFunc;
    }

    public FuncionarioBean getFuncionario(int id) throws SQLException {
        this.setConnection("sal");
        this.open();

        String SQL = "SELECT * FROM funcionario WHERE idFuncionario ="+id;
        this.prepare(SQL);
        this.executeQuery();

        MySQL conAux = new MySQL("sal", true);

        this.getRS().first();
            int idFunc = this.getRS().getInt("idFuncionario");

            String SQLaux = "SELECT e.idEspecialidade, e.nome AS nomeEsp "
                    + "FROM especiialidade e, especialidadeFuncionario ef"
                    + "WHERE ef.idEspecialidade = e.idEspecialidade "
                    + "AND ef.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<EspecialidadeBean> listaEsp = new ArrayList<EspecialidadeBean>();
            while (conAux.getRS().next()) {
                EspecialidadeBean esp = new EspecialidadeBean();
                esp.setIdEspecialidade(conAux.getRS().getInt("idEspecialidade"));
                esp.setNome(conAux.getRS().getString("nomeEsp"));
                listaEsp.add(esp);
            }

            SQLaux = "SELECT c.* FROM cargo c, cargoFuncionario cf "
                    + "WHERE c.idCargo = cf.idCargo "
                    + "AND cf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<CargoBean> listaCargo = new ArrayList<CargoBean>();
            while (conAux.getRS().next()) {
                CargoBean cargo = new CargoBean();
                cargo.setIdCargo(conAux.getRS().getInt("idCargo"));
                cargo.setDescricao(conAux.getRS().getString("descricao"));
                listaCargo.add(cargo);
            }

            SQLaux = "SELECT u.idUnidade u.nome AS nomeU, u.rua AS ruaU, u.numero AS numeroU, "
                    + "u.bairro AS bairroU, u.complemento AS compU "
                    + "FROM unidade u, unidadeFuncionario uf "
                    + "WHERE u.idUnidade = uf.idUnidade "
                    + "AND uf.idFuncionario = " + idFunc;
            conAux.prepare(SQL);
            conAux.executeQuery();

            List<UnidadeBean> listaUn = new ArrayList<UnidadeBean>();
            while (conAux.getRS().next()) {
                UnidadeBean unidade = new UnidadeBean();
                unidade.setIdUnidade(conAux.getRS().getInt("idUnidade"));
                unidade.setNome(conAux.getRS().getString("nomeU"));
                unidade.setRua(conAux.getRS().getString("ruaU"));
                unidade.setNumero(conAux.getRS().getInt("numeroU"));
                unidade.setBairro(conAux.getRS().getString("bairroU"));
                unidade.setComplemento(conAux.getRS().getString("compU"));
                listaUn.add(unidade);
            }

            FuncionarioBean func = new FuncionarioBean();
            func.setIdFuncionario(idFunc);
            func.setNome(this.getRS().getString("nome"));
            func.setCpfCnpj(this.getRS().getString("cpf"));
            func.setRgie(this.getRS().getString("rg"));
            func.setSexo(this.getRS().getString("sexo"));
            func.setTelefone(this.getRS().getString("telefone"));
            func.setCelular(this.getRS().getString("celular"));
            func.setRua(this.getRS().getString("rua"));
            func.setNumero(this.getRS().getInt("numero"));
            func.setComplemento(this.getRS().getString("complemento"));
            func.setBairro(this.getRS().getString("bairro"));
            func.setEstado(this.getRS().getString("estado"));
            func.setCidade(this.getRS().getString("cidade"));
            func.setAdmissao(this.getRS().getDate("admissao"));
            func.setDecreto(this.getRS().getInt("decreto"));
            func.setData(this.getRS().getDate("dtNascimento"));
            func.setRegistro(this.getRS().getString("registro"));
            func.setTipoRegistro(this.getRS().getString("tipoRegistro"));
            func.setUnidade(listaUn);
            func.setEspecialidade(listaEsp);
            func.setCargo(listaCargo);
        

        conAux.close();
        this.close();

        return func;
    }

    public void inserirUnidade(int idFunc, int idUni) throws SQLException{
        String SQL = "INSERT INTO funcionarioUnidade (idFuncionario, idUnidade) "
                + "VALUES (?,?)";
        this.prepare(SQL);
        this.setInt(1, idFunc);
        this.setInt(2, idUni);
        this.execute();
    }

    public void inserirEspecialidade(int idFunc, int idEsp) throws SQLException{
        String SQL = "INSERT INTO especialidadeFuncionario (idEspecialidade, idFuncionario) "
                + "VALUES (?,?)";
        this.prepare(SQL);
        this.setInt(1, idEsp);
        this.setInt(2, idFunc);
        this.execute();
    }

    public void inserirCargo(int idFunc, int idCargo) throws SQLException{
        String SQL = "INSERT INTO cargoFuncionario (idCargo, idFuncionario) "
                + "VALUES (?,?)";
        this.prepare(SQL);
        this.setInt(1, idCargo);
        this.setInt(2, idFunc);
        this.execute();
    }

    public void excluirUnidade(int id) throws SQLException{
        String SQL = "DELETE FROM funcionarioUnidade WHERE idFuncionario = "+id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public void excluirEspecialidade(int id) throws SQLException{
        String SQL = "DELETE FROM especialidadeFuncionario WHERE idFuncionario = "+id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public void excluirCargo(int id) throws SQLException{
        String SQL = "DELETE FROM cargoFuncionario WHERE idFuncionario = "+id;
        this.prepare(SQL);
        this.execute();
        this.close();
    }

    public int getCodigo() throws SQLException {
        String SQL = "SELECT HIGH_PRIORITY IFNULL(MAX(idFuncionario),0)+1 AS ID FROM funcionario";
        this.prepare(SQL);
        this.executeQuery();
        this.getRS().first();

        int novoId = this.getRS().getInt("ID");


        return novoId;
    }
}
