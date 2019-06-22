package model;

import dao.EventoDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity(name="evento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Evento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private String data;
    private String local;
    @ManyToOne
    private TipoEvento tipoEvento;
    @ManyToOne
    private Equipe equipe;
    
    public Evento () {
        
    }
    
    public Evento (String nome, String descricao, String data, String local, TipoEvento tipoEvento, Equipe equipe){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.tipoEvento = tipoEvento;
        this.equipe = equipe;
    }

    public Evento(Long id, String nome, String descricao, String data, String logradouro, TipoEvento tipoEvento, Equipe equipe) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setData(data);
        this.setLocal(logradouro);
        this.setTipoEvento(tipoEvento);
        this.setEquipe(equipe);
    }
    
     public void save() {
        EventoDAO.getInstance().save(this);
    }

    public void remove() {
        EventoDAO.getInstance().remove(this);
    }

    public static Evento find(Long id) {
        return EventoDAO.getInstance().find(id);
    }

    public static List<Evento> findAll() {
        return EventoDAO.getInstance().findAll();
    }

    public Long getIdEvento() {
        return id;
    }

    public void setIdEvento(Long id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nome;
    }

    public void setNomeEvento(String nome) {
        this.nome = nome;
    }
    
    public String getDescricaoEvento() {
        return descricao;
    }

    public void setDescricaoEvento(String descricao) {
        this.descricao = descricao;
    }
    public String getLocalEvento() {
        return local;
    }

    public void setLocalEvento(String local) {
        this.local = local;
    }
    
    public String getDataEvento() {
        return data;
    }

    public void setDataEvento(String data) {
        this.data = data;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}