package model;

import dao.EventoDAO;
import java.sql.SQLException;
import java.util.List;



public class Evento{
    private Integer idEvento;
    private String nomeEvento;
    private String descricaoEvento;
    private String dataEvento;
    private String logradouroEvento;
    private Integer idTipoEvento;
    private Integer idEquipe;

    public Evento(int idTipoEvento, int idEvento, String nomeEvento, String descricaoEvento, String dataEvento, String logradouroEvento, int idEquipe) {
      this.setIdTipoEvento(idTipoEvento);
      this.setIdEvento(idEvento);
      this.setNomeEvento(nomeEvento);
      this.setDescricaoEvento(descricaoEvento);
      this.setDataEvento(dataEvento);
      this.setLogradouroEvento(logradouroEvento);
      this.setIdEquipe(idEquipe);
    }





    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLogradouroEvento() {
        return logradouroEvento;
    }

    public void setLogradouroEvento(String logradouroEvento) {
        this.logradouroEvento = logradouroEvento;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }
    
    
    public static Evento lerEvento(int idEvento) throws SQLException, ClassNotFoundException {
        return EventoDAO.lerEvento(idEvento);
    }

    public static List<Evento> lerTodosEventos() throws ClassNotFoundException, SQLException {
        return EventoDAO.lerTodosEventos();
    }

    public void inserir() throws SQLException, ClassNotFoundException {
        EventoDAO.inserir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        EventoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        EventoDAO.excluir(this);
    }
}