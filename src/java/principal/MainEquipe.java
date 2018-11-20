package principal;

import dao.AtletaDAO;
import dao.EquipeDAO;
import dao.EsporteDAO;
import dao.EventoDAO;
import dao.GestorDAO;
import dao.TipoEventoDAO;
import model.Equipe;
import java.sql.SQLException;
import model.Atleta;
import model.Gestor;

public class MainEquipe {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        GestorDAO.lerTodosGestores().forEach(gestor->System.out.println(gestor.getNomeUsuario()));
        
    }
}
