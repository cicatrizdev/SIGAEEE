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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Gestor() {

    }

    public Gestor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Gestor(Long idGestor, String nomeGestor, String emaiGestor, String senhaGestor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
