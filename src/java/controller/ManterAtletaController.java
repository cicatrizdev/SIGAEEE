package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import model.Atleta;

@WebServlet(name = "ManterAtletaController")
public class ManterAtletaController extends HttpServlet {

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
            request.setAttribute("atletas", Atleta.lerTodosAtletas());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("codCurso"));
                Atleta atleta = Atleta.lerAtleta(id);
                request.setAttribute("atleta", atleta);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroAtleta.jsp");
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
        int idAtleta = Integer.parseInt(request.getParameter("txtIdAtleta"));
        Atleta atleta = new Atleta();
        if (operacao.equals("Incluir")) {
            atleta.inserir();
        } else if (operacao.equals("Editar")) {
            atleta.alterar();
        } else if (operacao.equals("Excluir")) {
            atleta.excluir();
        }
        request.getRequestDispatcher("PesquisaAtletaController").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
