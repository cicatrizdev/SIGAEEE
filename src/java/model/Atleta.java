package model;

import dao.AtletaDAO;
import java.io.Serializable;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Atleta extends Usuario implements Serializable {

    public Atleta(String nomeUsuario, String email, String senha, float peso, float altura, String dataNascimento) {
        super(nomeUsuario, email, senha);

    }

    public Atleta(Long id) {
        super(id);
    }
    
    public Atleta(){
        
    }

    public void save() {
        AtletaDAO.getInstance().save(this);
    }

    public void remove() {
        AtletaDAO.getInstance().remove(this);
    }

    public static Atleta find(Long id) {
        return AtletaDAO.getInstance().find(id);
    }

    public static List<Atleta> findAll() {
        return AtletaDAO.getInstance().findAll();
    }
}