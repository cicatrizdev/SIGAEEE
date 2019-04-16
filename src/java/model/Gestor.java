package model;

import dao.GestorDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Gestor extends Usuario implements Serializable {

    public Gestor () {
        
    }
    
    public Gestor(String nome, String email, String senha) {
        super(nome,  email, senha);
    }
    
    public void save() {
        GestorDAO.getInstance().save(this);
    }

    public void remove() {
        GestorDAO.getInstance().remove(this);
    }
    
    public static Gestor find(Long id){
        return GestorDAO.getInstance().find(id);
    }
    
    public static List<Gestor> findAll(){
        return GestorDAO.getInstance().findAll();
    } 
}
