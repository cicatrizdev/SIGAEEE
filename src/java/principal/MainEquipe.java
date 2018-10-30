package principal;

import dao.AtletaDAO;
import java.sql.SQLException;
import model.Atleta;

public class MainEquipe {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Atleta a = new Atleta();
        a.setDataNascimento("10/10/2010");
        a.setEmail("Email");
        a.setAltura(Double.parseDouble("1.80"));
        a.setPeso(Double.parseDouble("81.0"));
        a.setNomeUsuario("Allan");
        a.setSenha("AAAAA");
        System.out.println(a.toString());
        AtletaDAO.inserir(a);
    }
}
