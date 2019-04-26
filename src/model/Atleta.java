package model;

import dao.AtletaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity(name="atleta")
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
    public Long getIdUsuario() {
        return super.getIdUsuario(); //To change body of generated methods, choose Tools | Templates.
    }
    
}