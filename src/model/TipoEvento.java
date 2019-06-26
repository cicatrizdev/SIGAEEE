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

@Entity(name="tipoEvento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TipoEvento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    
    public TipoEvento () {
        
    }
    
    public TipoEvento(Long id, String nome){
        this.setIdTipoEvento(id);
        this.setNomeTipoEvento(nome);
    }
    
    public void save() throws NoSuchMethodException {
        DAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        DAO.getInstance().remove(this);
    }

    public static TipoEvento find(Long id) throws ClassNotFoundException {
        return(TipoEvento) DAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return DAO.getInstance().findAll();
    }

    public Long getIdTipoEvento() {
        return id;
    }

    public void setIdTipoEvento(Long id) {
        this.id = id;
    }

    public String getNomeTipoEvento() {
        return nome;
    }

    public void setNomeTipoEvento(String nome) {
        this.nome = nome;
    }
}