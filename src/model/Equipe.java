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

@Entity(name = "equipe")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String logo;
    private String playbook;
    @ManyToOne
    private Gestor gestor;
    @ManyToOne
    private Esporte esporte;

    public Equipe() {

    }

    public Equipe(Long id, String nome, String logo, String playbook, Gestor gestor, Esporte esporte) {
        this.setIdEquipe(id);
        this.nome = nome;
        this.gestor = gestor;
        this.esporte = esporte;
        this.setLogo(logo);
        this.setPlaybook(playbook);
    }

    public Equipe(String nome, Long id_gestor, Long id_esporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPlaybook() {
        return playbook;
    }

    public void setPlaybook(String playbook) {
        this.playbook = playbook;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

}
