package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import model.Equipe;
import model.Esporte;

@WebServlet(name = "ManterEquipeController")
public class ManterEquipeController extends HttpServlet {
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException{
        String operacao = request.getParameter("operacao");
        int id_equipe = Integer.parseInt(request.getParameter("txtIdEquipe"));
        String nome = request.getParameter("txtNomeEquipe");
        String logo = request.getParameter("txtLogoEquipe");
        String playbook= request.getParameter("txtPlaybookEquipe");
        Esporte esporte = new Esporte(Integer.parseInt(request.getParameter("optIdEsporte")),request.getParameter("optEsporte"));
              
         
        try{
/*            Equipe equipe = null;
            if (esporte != 0){
                equipe= Equipe.esporte.getIdEsporte();
            }
*/  
        Equipe equipe = new Equipe(id_equipe, nome, logo, playbook, esporte);
        if(operacao.equals("Incluir")){
            equipe.inserir();
        }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
        view.forward(request, response);
        }catch (IOException e){
            throw new ServletException(e);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
