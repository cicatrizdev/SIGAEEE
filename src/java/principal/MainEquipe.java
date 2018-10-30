/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.AtletaDAO;
import dao.EquipeDAO;
import dao.EsporteDAO;
import java.sql.SQLException;
import model.Atleta;
import model.Equipe;
import model.Esporte;


/**
 *
 * @author Familia
 */
public class MainEquipe {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         // TODO code application logic here
         Atleta a = new Atleta(2, "Vitor", "j@j.com", "md5", 10.0, 10.0, "23/10/1998");
                   
         AtletaDAO.inserir(a);
         
         
         
    }  
}
