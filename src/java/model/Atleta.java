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

    public Atleta(int id, float peso, float altura, String data, int equipe, int posicao, int idUsuario, String nome, String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdAtleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}