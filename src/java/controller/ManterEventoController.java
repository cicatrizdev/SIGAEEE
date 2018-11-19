package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Equipe;
import model.TipoEvento;

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
            request.setAttribute("tiposEvento",TipoEvento.lerTodosTiposEventos());
            request.setAttribute("equipes",Equipe.lerTodasEquipes());
            if (!operacao.equals("Incluir")) {
                int idEvento = Integer.parseInt(request.getParameter("idEvento"));
                Evento evento = Evento.lerEvento(idEvento);
                request.setAttribute("evento", evento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroEvento.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        int idEvento = Integer.parseInt(request.getParameter("txtIdEvento"));
        String nomeEvento = request.getParameter("txtNomeEvento");
        String descricaoEvento = request.getParameter("txtDescricaoEvento");
        String dataEvento = request.getParameter("txtDataEvento");
        String logradouroEvento = request.getParameter("txtLogradouroEvento");
        int idTipoEvento = Integer.parseInt(request.getParameter("intIdTipoEvento"));
        int idEquipe = Integer.parseInt(request.getParameter("intIdEquipe"));

       Evento evento = new Evento(idTipoEvento, idEvento, nomeEvento, descricaoEvento, dataEvento, logradouroEvento, idEquipe);
        if (operacao.equals("Incluir")) {
            evento.inserir();
        } else {
            if (operacao.equals("Editar")) {
                evento.alterar();
            } else {
                if (operacao.equals("Excluir")) {
                   evento.excluir();
                }
            }
        } 
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEventoController");
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
