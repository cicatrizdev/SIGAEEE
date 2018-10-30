package model;

import dao.AtletaDAO;

import java.sql.SQLException;
import java.util.List;

public class Atleta extends Usuario {

    private Integer idAtleta;
    private Double peso;
    private Double altura;
    private String dataNascimento;

    public Atleta(Integer idUsuario, String nomeUsuario, String email, String senha, Double peso, Double altura, String dataNascimento) {
        super(idUsuario, nomeUsuario, email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public Atleta() {
        super();
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void inserir() throws SQLException, ClassNotFoundException {
        AtletaDAO.inserir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AtletaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AtletaDAO.excluir(this);
    }

    public static Atleta lerAtleta(int idAtleta) throws SQLException, ClassNotFoundException {
        return AtletaDAO.lerAtleta(idAtleta);
    }

    public static List<Atleta> lerTodosAtletas() throws ClassNotFoundException, SQLException {
        return AtletaDAO.lerTodosAtletas();
    }

}
