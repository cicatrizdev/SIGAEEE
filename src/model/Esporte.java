package model;

import dao.EsporteDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="esporte")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Esporte implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    
    public Esporte () {
        
    }
    
    public Esporte(Long id){
        this.id = id;
    }

    public Esporte(Long id, String nome) {
        setIdEsporte(id);
        setNomeEsporte(nome);
    }

    public Esporte(String nome) {
        setNomeEsporte(nome); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void save() {
        EsporteDAO.getInstance().save(this);
    }

    public void remove() {
        EsporteDAO.getInstance().remove(this);
    }

    public static Esporte find(Long id) {
        return EsporteDAO.getInstance().find(id);
    }

    public static List<Esporte> findAll() {
        return EsporteDAO.getInstance().findAll();
    }

    public Long getIdEsporte() {
        return id;
    }

    public void setIdEsporte(Long id) {
        this.id = id;
    }

    public String getNomeEsporte() {
        return nome;
    }

    public void setNomeEsporte(String nome) {
        this.nome = nome;
    }

}
