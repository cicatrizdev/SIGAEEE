package model;

import dao.GestorDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "gestor")
public class Gestor extends Usuario implements Serializable {

    public Gestor() {

    }

    public Gestor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Gestor(Long idGestor, String nomeGestor, String emaiGestor, String senhaGestor) {
        super(idGestor, nomeGestor, emaiGestor, senhaGestor);
    }

    public void save() {
        GestorDAO.getInstance().save(this);
    }

    public void remove() {
        GestorDAO.getInstance().remove(this);
    }

    public static Gestor find(Long id) {
        return GestorDAO.getInstance().find(id);
    }

    public static List<Gestor> findAll() {
        return GestorDAO.getInstance().findAll();
    }

   
}
