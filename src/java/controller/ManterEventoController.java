package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import dao.EventoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterEventoController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("Evento", Evento.lerTodosEventos());
            if (!operacao.equals("Incluir")) {
                int codCurso = Integer.parseInt(request.getParameter("codEvento"));
                Evento evento = Evento.lerEvento(codCurso);
                request.setAttribute("evento", evento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEvento.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        Integer idEvento = Integer.parseInt(request.getParameter("txtIdEvento"));
        String nomeEvento = request.getParameter("txtNomeEvento");
        String descricaoEvento = request.getParameter("txtDescricaoEvento");
        String dataEvento = request.getParameter("txtDataEvento");
        String logradouroEvento = request.getParameter("txtLogradouroEvento");

        Evento evento = new Evento();
        if (operacao.equals("Incluir")) {
            EventoDAO.inserir(evento);
        } else {
            if (operacao.equals("Editar")) {
                EventoDAO.alterar(evento);
            } else {
                if (operacao.equals("Excluir")) {
                    EventoDAO.excluir(evento);
                }
            }
        } 
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
            view.forward(request, response);
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";

    }
}
