package dao;

import model.Equipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    /**
     *
     * @param equipe
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void inserir(Equipe equipe) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO equipe (nome, esporte_id) VALUE (?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNomeEquipe());
            comando.setInt(2, equipe.getEsporte().getIdEsporte());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Equipe equipe) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE equipe SET nome = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, equipe.getNomeEquipe());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Equipe lerEquipe(Integer idEquipe) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Equipe equipe = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM equipe WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, idEquipe);
            ResultSet rs = comando.executeQuery();
            rs.first();
            equipe = getFromDatabase(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return equipe;
    }

    public static List<Equipe> lerTodasEquipes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Equipe> equipes = new ArrayList<Equipe>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM equipe";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                equipes.add(getFromDatabase(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return equipes;
    }

    private static Equipe getFromDatabase(ResultSet rs) throws SQLException {
        return new Equipe(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("logo"),
                rs.getString("playbook"),
                rs.getInt("esporte_id")
        );
    }
}
