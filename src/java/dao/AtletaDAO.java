package dao;

import model.Atleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    public static void inserir(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Long id = 0L;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha,tipo) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, atleta.getNomeUsuario());
            comando.setString(2, atleta.getEmail());
            comando.setString(3, atleta.getSenha());
            comando.setInt(4,0);
            comando.execute();
            id = BD.returnId(comando);
        } catch (SQLException e) {
            throw e;
        }
        try {
            comando = conexao.prepareStatement("INSERT INTO atleta (peso, altura, data_nascimento, usuario_id) values (?,?,?,?)");
            comando.setDouble(1, atleta.getPeso());
            comando.setDouble(2, atleta.getAltura());
            comando.setString(3, atleta.getDataNascimento());
            comando.setInt(4, Integer.parseInt(String.valueOf(id)));
            comando.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void alterar(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE atleta SET peso = ?, altura = ?, data_nascimento = ? WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setDouble(1, atleta.getPeso());
            comando.setDouble(2, atleta.getAltura());
            comando.setString(3, atleta.getDataNascimento());
            comando.setInt(4, atleta.getIdAtleta());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "DELETE FROM atleta WHERE id_at = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, atleta.getIdAtleta());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Atleta lerAtleta(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM atleta JOIN usuario ON usuario.id = atleta.usuario_id WHERE atleta.id_atleta = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            rs.first();
            Atleta atleta = getFromResultSet(rs);
            BD.fecharConexao(conexao, comando);
            return atleta;
        } catch (SQLException e) {
            BD.fecharConexao(conexao, comando);
            e.printStackTrace();
        }
        return null;
    }

    private static Atleta getFromResultSet(ResultSet rs) throws SQLException {
        return new Atleta(rs.getInt("id_atleta"),
                rs.getFloat("peso"),
                rs.getFloat("altura"),
                rs.getString("data_nascimento"),
                rs.getInt("posicao_id"),
                rs.getInt("equipe_id"),
                rs.getInt("usuario_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"));
    }

    public static List<Atleta> lerTodosAtletas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ArrayList<Atleta> atletas = new ArrayList<>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM atleta RIGHT JOIN usuario ON atleta.usuario_id = usuario.id";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                atletas.add(getFromResultSet(rs));
            }
            BD.fecharConexao(conexao, comando);
            return atletas;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return new ArrayList<>();
    }
}
