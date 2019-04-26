package model;

import dao.GestorDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity(name="gestor")
public class Gestor extends Usuario implements Serializable {

    public Gestor () {
        
    }
    
    public Gestor(String nome, String email, String senha) {
        super(nome,  email, senha);
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
    
    public static Gestor find(Long id){
        return GestorDAO.getInstance().find(id);
    }
    
    public static List<Gestor> findAll(){
        return GestorDAO.getInstance().findAll();
    } 

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSenha() {
        return super.getSenha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNomeUsuario(String nome) {
        super.setNomeUsuario(nome); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomeUsuario() {
        return super.getNomeUsuario(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdUsuario(Long id) {
        super.setIdUsuario(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getIdUsuario() {
        return super.getIdUsuario(); //To change body of generated methods, choose Tools | Templates.
    }
}
