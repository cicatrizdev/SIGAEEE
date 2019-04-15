package model;

import dao.LogarDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
public class Logar implements Serializable {
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
