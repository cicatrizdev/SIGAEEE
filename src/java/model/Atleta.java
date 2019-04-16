package model;

import dao.AtletaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Atleta extends Usuario implements Serializable {
    private float peso;
    private float altura;
    private String dataNascimento;
    
    public Atleta () {
        
    }
    
    public Atleta(float peso, float altura, String dataNascimento, String nome, String email, String senha) {
        super(nome,  email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }
    
    public void save() {
        AtletaDAO.getInstance().save(this);
    }

    public void remove() {
        AtletaDAO.getInstance().remove(this);
    }
    
    public static Atleta find(Long id){
        return AtletaDAO.getInstance().find(id);
    }
    
    public static List<Atleta> findAll(){
        return AtletaDAO.getInstance().findAll();
    } 
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}