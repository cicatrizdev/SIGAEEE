package principal;

import dao.AtletaDAO;
import dao.EquipeDAO;
import java.sql.SQLException;
import model.Atleta;

public class MainEquipe {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
    EquipeDAO.lerTodasEquipes().forEach(item->System.out.print(item.getNomeEquipe()));
    }
}
