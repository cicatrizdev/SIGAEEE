package model;

import dao.AtletaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "atleta")
public class Atleta extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float peso;
    private float altura;
    private String dataNascimento;
   
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Posicao posicao;

    public Atleta() {

    }

    public Atleta(float peso, float altura, String dataNascimento, String nome, String email, String senha) {
        super(nome, email, senha);
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

    public static Atleta find(Long id) {
        return AtletaDAO.getInstance().find(id);
    }

    public static List<Atleta> findAll() {
        return AtletaDAO.getInstance().findAll();
    }

}
