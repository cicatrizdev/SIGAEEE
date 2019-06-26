package model;

import dao.DAO;
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
        setNomeEsporte(nome);
    }
    
    public void save() throws NoSuchMethodException {
        DAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        DAO.getInstance().remove(this);
    }

    public static Esporte find(Long id) throws ClassNotFoundException {
        return (Esporte) DAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return DAO.getInstance().findAll();
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
