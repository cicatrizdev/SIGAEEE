package model;

import dao.EsporteDAO;

public class Esporte {

    public static Object lerTodosEsportes() throws ClassNotFoundException {
        return EsporteDAO.lerTodosEsportes();
    }
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
