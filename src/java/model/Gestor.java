package model;

import dao.GestorDAO;
import java.sql.SQLException;
import java.util.List;

public class Gestor extends Usuario {

    public static Gestor lerGestor(int id) throws SQLException, ClassNotFoundException {
        return GestorDAO.lerGestor(id);
    }

    public static List<Gestor> lerTodosGestores() throws ClassNotFoundException, SQLException {
        return GestorDAO.lerTodosGestores();
    }
    private Integer idGestor;


    public Gestor(Integer idUsuario, String nomeUsuario, String email, String senha, Integer idGestor){
        super(idUsuario, nomeUsuario, email, senha);
        this.setIdGestor(idGestor);

    }

    public Integer getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(Integer idGestor) {
        this.idGestor = idGestor;
    }

    public void inserir() throws SQLException, ClassNotFoundException {
        GestorDAO.inserir(this);
    }
}
