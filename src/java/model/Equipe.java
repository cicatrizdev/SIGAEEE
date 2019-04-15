package model;

import dao.EquipeDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Equipe implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Atleta atleta;
    @ManyToOne
    private Gestor gestor;
    @ManyToOne
    private Esporte esporte;
    
    public Equipe () {
        
    }
    
    public Equipe(String nome, Atleta atleta, Gestor gestor, Esporte esporte){
        this.nome = nome;
        this.atleta = atleta;
        this.gestor = gestor;
        this.esporte = esporte;
    }
    
    public void save() {
        EquipeDAO.getInstance().save(this);
    }

    public void remove() {
        EquipeDAO.getInstance().remove(this);
    }

    public static Equipe find(Long id) {
        return EquipeDAO.getInstance().find(id);
    }

    public static List<Equipe> findAll() {
        return EquipeDAO.getInstance().findAll();
    }

    public Long getIdEquipe() {
        return id;
    }

    public void setIdEquipe(Long id) {
        this.id = id;
    }

    public String getNomeEquipe() {
        return nome;
    }

    public void setNomeEquipe(String nome) {
        this.nome = nome;
    }

}

