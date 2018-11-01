package model;

import dao.EventoDAO;
import java.sql.SQLException;
import java.util.List;



public class Evento extends TipoEvento {
    private Integer idEvento;
    private String nomeEvento;
    private String descricaoEvento;
    private String dataEvento;
    private String logradouroEvento;

    public Evento(Integer idTipoEvento, String nomeTipoEvento, Integer idEvento, String nomeEvento, String descricaoEvento, String dataEvento, String logradouroEvento) {
        super(idTipoEvento, nomeTipoEvento);
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
        this.logradouroEvento = logradouroEvento;
    }

    public Evento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public static Evento lerEvento(int idEvento) throws SQLException, ClassNotFoundException {
        return EventoDAO.lerEvento(idEvento);
    }

    public static List<Evento> lerTodosEventos() throws ClassNotFoundException, SQLException {
        return EventoDAO.lerTodosEventos();
    }
}