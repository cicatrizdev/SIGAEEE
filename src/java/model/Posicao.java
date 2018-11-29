package model;

import dao.PosicaoDAO;
import java.sql.SQLException;

public class Posicao {

    public static Object lerTodasPosicoes() throws ClassNotFoundException {
        return PosicaoDAO.lerTodasPosicoes();
    }
    public static Object lerPosicao(int id) throws ClassNotFoundException {
        return PosicaoDAO.lerPosicao(id);
    }
    private Integer idPosicao;
    private Integer idEsporte;
    private String nomePosicao;

    public Posicao(Integer idEsporte, Integer idPosicao, String nomePosicao) {
        this.setIdEsporte(idEsporte);
        this.setIdPosicao(idPosicao);
        this.setNomePosicao(nomePosicao);
    }

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }

    public Integer getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Integer idPosicao) {
        this.idPosicao = idPosicao;
    }

    public String getNomePosicao() {
        return nomePosicao;
    }

    public void setNomePosicao(String nomePosicao) {
        this.nomePosicao = nomePosicao;
    }

    public void inserir() throws SQLException, ClassNotFoundException {
        PosicaoDAO.inserir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PosicaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PosicaoDAO.excluir(this);
    }
}
