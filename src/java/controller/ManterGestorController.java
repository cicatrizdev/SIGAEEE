package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import dao.GestorDAO;
import model.Gestor;

@WebServlet(name = "ManterGestorController")
public class ManterGestorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException, IOException {
        String acao = request.getParameter("acao");
        request.setAttribute("operacao", "aeee");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", "operacao");
            request.setAttribute("Gestores", GestorDAO.lerTodosGestores());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("idGestor"));
                Gestor gestor = GestorDAO.lerGestor(id);
                request.setAttribute("Gestor", gestor);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroGestor.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException {
        String operacao = request.getParameter("operacao");
        int idGestor = Integer.parseInt(request.getParameter("txtIdGestor"));
    //    Gestor gestor = new Gestor();
        if (operacao.equals("Incluir")) {
      //      gestor.inserir();
        } else if (operacao.equals("Editar")) {
        //    gestor.alterar();
        } else if (operacao.equals("Excluir")) {
          //  gestor.excluir();
        }
        request.getRequestDispatcher("PesquisaAtletaController").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
