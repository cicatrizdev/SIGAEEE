package model;

import dao.EquipeDAO;
import java.sql.SQLException;
import java.util.List;

public class Equipe {

    private int idEquipe;
    private String nomeEquipe;
    private String logo;
    private String playbook;
    private Esporte esporte;
    private int idEsporte;

    public Equipe(int idEquipe, String nomeEquipe,String logo, String playbook, Esporte esporte) {
        this.setIdEquipe(idEquipe);
        this.setNomeEquipe(nomeEquipe);
        this.setEsporte(esporte);
        this.setLogo(logo);
        this.setPlaybook(playbook);
        this.setIdEsporte(esporte.getIdEsporte());
    }

    public int getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(int idEsporte) {
        this.idEsporte = idEsporte;
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

    public Equipe(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public void inserir() throws SQLException, ClassNotFoundException {
        EquipeDAO.inserir(this);
    }
        public static List<Equipe> lerTodasEquipes() throws ClassNotFoundException, SQLException {
        return EquipeDAO.lerTodasEquipes();
    }
}
