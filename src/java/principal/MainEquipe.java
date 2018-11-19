package principal;

import dao.AtletaDAO;
import dao.EquipeDAO;
import dao.EsporteDAO;
import dao.EventoDAO;
import dao.TipoEventoDAO;
import model.Equipe;
import java.sql.SQLException;
import model.Atleta;

public class MainEquipe {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        EventoDAO.lerTodosEventos().forEach(evento->System.out.println(evento.getNomeEvento()));
        TipoEventoDAO.lerTodosTiposEventos().forEach(tipo->System.out.println(tipo.getNomeTipoEvento()));
    }
}
