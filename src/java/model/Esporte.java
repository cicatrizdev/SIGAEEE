package model;

public class Esporte {
    private int idEsporte;
    private String nomeEsporte;

    public Esporte(int idEsporte, String nomeEsporte) {
        this.idEsporte = idEsporte;
        this.nomeEsporte = nomeEsporte;
    }

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(int idEsporte) {
        this.idEsporte = idEsporte;
    }

    public String getNomeEsporte() {
        return nomeEsporte;
    }

    public void setNomeEsporte(String nomeEsporte) {
        this.nomeEsporte = nomeEsporte;
    }
}
