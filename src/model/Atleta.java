package model;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "atleta")
public class Atleta extends Usuario implements Serializable {

    private float peso;
    private float altura;
    private String dataNascimento;
   
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Posicao posicao;

    public Atleta() {

    }

    public Atleta(Long id,float peso, float altura, String dataNascimento, String nome, String email, String senha, Equipe equipe, Posicao posicao) {
        super(id, nome, email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
        this.setEquipe(equipe);
        this.setPosicao(posicao);
    }   

    public void save() throws NoSuchMethodException {
        DAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        DAO.getInstance().remove(this);
    }

    public static Atleta find(Long id) throws ClassNotFoundException {
        return (Atleta) DAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return DAO.getInstance().findAll();
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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

}
