/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.EquipeDAO;
import dao.EsporteDAO;
import java.sql.SQLException;
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
         Esporte b = new Esporte(1, "Futebol");
         Equipe a = new Equipe(2, "FCBRO", b);
        
        String nome = a.getEsporte().getNomeEsporte();
        
        System.out.println(nome);
        
        EsporteDAO.inserir(b);
        EquipeDAO.inserir(a);
                
         
         
         
         
    }  
}
