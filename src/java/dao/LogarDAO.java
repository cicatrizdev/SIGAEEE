/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Logar;

/**
 *
 * @author Familia
 */
public class LogarDAO {

    public static String logando(Logar logar) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM usuario where usuario.email = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, logar.getEmail());
            ResultSet rs = comando.executeQuery();
            rs.first();
            int tipo = rs.getInt("tipo");
            String senha = rs.getString("senha");
            System.out.println("tipo"+tipo);
            if (tipo == 1) {
                if (senha == null ? logar.getSenha() == null : senha.equals(logar.getSenha())) {
                    return "gestor";
                }

            } else if (tipo == 0) {
                if (senha == null ? logar.getSenha() == null : senha.equals(logar.getSenha())) {
                    return "atleta";
                }
            }
            }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao, comando);
        }
        return "error";
        }

    

    public static boolean atleta(Logar logar) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM usuario where usuario.email = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, logar.getEmail());
            ResultSet rs = comando.executeQuery();
            rs.first();
            int tipo = rs.getInt("tipo");
            String senha = rs.getString("senha");
            if (tipo == 0) {
                if (senha == logar.getSenha()) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return false;
    }

}
