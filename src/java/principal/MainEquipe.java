package principal;

import dao.AtletaDAO;
import dao.EquipeDAO;
import dao.EsporteDAO;
import model.Equipe;
import java.sql.SQLException;
import model.Atleta;

public class MainEquipe {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Equipe equipe = new Equipe(6, "Teste", "url", "url", 3);
        equipe.inserir();
    }
}
