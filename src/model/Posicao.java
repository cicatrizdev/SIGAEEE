package model;

import dao.PosicaoDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity(name="posicao")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Posicao implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Esporte esporte;
    
    public Posicao () {
        
    }
    
    public Posicao(String nome, Esporte esporte){
        this.nome = nome;
        this.esporte = esporte;
    }

    public Posicao(Long id, String nome, Esporte esporte) {
        this.setId(id);
        this.setNome(nome);
        this.setEsporte(esporte);
    }

    public Posicao(Long idEsporte, String nome) {
        this.setNome(nome);
        Esporte esporte = Esporte.find(idEsporte);
        this.setEsporte(esporte);
    }
    
    public void save() {
        PosicaoDAO.getInstance().save(this);
    }

    public void remove() {
        PosicaoDAO.getInstance().remove(this);
    }
    
    public static Posicao find(Long id){
        return PosicaoDAO.getInstance().find(id);
    }
    
    public static List<Posicao> findAll(){
        return PosicaoDAO.getInstance().findAll();
    } 
    
    public Long getIdPosicao(){
        return id;
    }
    
    public void setIdPosicao(Long id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomePosicao() {
        return nome;
    }

    public void setNomePosicao(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }
    
}
