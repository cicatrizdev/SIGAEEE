/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LogarDAO;
import java.sql.SQLException;

/**
 *
 * @author Familia
 */
public class Logar {
    private String email;
    private String senha;

    public Logar(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String verificar() throws ClassNotFoundException, SQLException {
        return LogarDAO.logando(this);
    }
    
}
