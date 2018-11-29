package model;

import dao.AtletaDAO;

import java.sql.SQLException;
import java.util.List;

public class Atleta extends Usuario {

    private Integer idAtleta;
    private float peso;
    private float altura;
    private String dataNascimento;
    private int posicao;
    private int equipe;

    public Atleta(Integer idUsuario, String nomeUsuario, String email, String senha, float peso, float altura, String dataNascimento) {
        super(idUsuario, nomeUsuario, email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public Atleta() {
        super();
    }

    public Atleta(String nome, String email, String senha, String data, float altura, float peso) {
        super(nome, email, senha);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setDataNascimento(data);
        
    }

    public Atleta(int id_atleta, float peso, float altura, String data_nascimento, int posicao, int equipe, int usuario_id, String nome, String email, String senha) {
       super(nome,email,senha);
       this.setIdAtleta(id_atleta);
       this.setPeso(peso);
       this.setAltura(altura);
       this.setDataNascimento(data_nascimento);
       this.setPosicao(posicao);
       this.setEquipe(equipe);
       this.setIdUsuario(usuario_id);
       
       
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }
    

    public void inserir() throws SQLException, ClassNotFoundException {
        AtletaDAO.inserir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AtletaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        System.out.println("Excluir");
        AtletaDAO.excluir(this);
    }

    public static Atleta lerAtleta(int idAtleta) throws SQLException, ClassNotFoundException {
        return AtletaDAO.lerAtleta(idAtleta);
    }

    public static List<Atleta> lerTodosAtletas() throws ClassNotFoundException, SQLException {
        return AtletaDAO.lerTodosAtletas();
    }

}
