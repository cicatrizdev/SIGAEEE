package dao;

import model.Gestor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDAO {

    public static void inserir(Gestor gestor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Long id = 0L;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, tipo) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, gestor.getNomeUsuario());
            comando.setString(2, gestor.getEmail());
            comando.setString(3, gestor.getSenha());
            comando.setInt(4, 1);
            comando.execute();
            id = BD.returnId(comando);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            comando = conexao.prepareStatement("INSERT INTO gestor (usuario_id) values (?)");
            comando.setInt(1, Integer.parseInt(String.valueOf(id)));
            comando.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterar(Gestor gestor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE gestor SET idGestor = ? WHERE id = ?"; //ver query, essa merda TA MUITO ERRADA
            comando = conexao.prepareStatement(sql);
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Gestor gestor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "DELETE FROM gestor WHERE id = ?";
            String sql2 = "DELETE FROM usuario WHERE id = ?";
            comando = conexao.prepareStatement(sql);
            comando = conexao.prepareStatement(sql2);
            comando.setInt(1, gestor.getIdGestor());
            comando.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Gestor lerGestor(Integer id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Gestor gestor = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM gestor RIGHT JOIN usuario ON gestor.usuario_id = usuario.id WHERE id_gestor = ? "; // Arruma aqui o select com um select nomeado
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            rs.first();
            gestor = getFromResultSet(rs);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return gestor;
    }

    public static List<Gestor> lerTodosGestores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Gestor> gestores = new ArrayList<Gestor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM gestor LEFT JOIN usuario ON gestor.usuario_id = usuario.id";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                gestores.add(getFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return gestores;
    }

    private static Gestor getFromResultSet(ResultSet rs) throws SQLException {
            return new Gestor(rs.getInt("usuario_id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    (rs.getInt("id_gestor")));
    }
}
