package controller;

import dao.EquipeDAO;
import dao.TipoEventoDAO;
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
            request.setAttribute("tiposEvento",TipoEvento.findAll());
            request.setAttribute("equipes",Equipe.findAll());
            if (!operacao.equals("Incluir")) {
                Long id = Long.parseLong(request.getParameter("id"));
                Evento evento = Evento.find(id);
                request.setAttribute("evento", evento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroEvento.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if (!operacao.equals("Incluir")) {
            Long id = Long.parseLong(request.getParameter("txtIdEvento"));
        }
        String nome = request.getParameter("txtNomeEvento");
        String descricao = request.getParameter("txtDescricaoEvento");
        String data = request.getParameter("txtDataEvento");
        String logradouro = request.getParameter("txtLogradouroEvento");
        Long tipoEvento = Long.parseLong(request.getParameter("intIdTipoEvento"));
        Long equipe = Long.parseLong(request.getParameter("intIdEquipe"));
        
       TipoEvento tipoEventoo = TipoEventoDAO.getInstance().find(tipoEvento);
       Equipe equipee = EquipeDAO.getInstance().find(equipe);
       Evento evento = new Evento (nome, descricao, data, logradouro, tipoEventoo, equipee);
        if (operacao.equals("Incluir")) {
            evento.save();
        } else {
            if (operacao.equals("Editar")) {
                evento.save();
            } else {
                if (operacao.equals("Excluir")) {
                   evento.remove();
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
