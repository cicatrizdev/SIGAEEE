package model;

import dao.TipoEventoDAO;
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
    
    public TipoEvento(Long id){
        this.id = id;
    }
    
    public void save() {
        TipoEventoDAO.getInstance().save(this);
    }

    public void remove() {
        TipoEventoDAO.getInstance().remove(this);
    }

    public static TipoEvento find(Long id) {
        return TipoEventoDAO.getInstance().find(id);
    }

    public static List<TipoEvento> findAll() {
        return TipoEventoDAO.getInstance().findAll();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}