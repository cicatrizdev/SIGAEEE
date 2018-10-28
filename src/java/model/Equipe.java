package model;

public class Equipe{
    private int idEquipe;
    private String nomeEquipe;
    private Esporte esporte;
        
    public Equipe(int idEquipe, String nomeEquipe, Esporte esporte) {
        this.idEquipe = idEquipe;
        this.nomeEquipe = nomeEquipe;
        this.esporte = esporte;
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
}
