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
                Long idEvento = Long.parseLong(request.getParameter("idEvento"));
                Evento evento = Evento.find(idEvento);
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
        int idEvento = Integer.parseInt(request.getParameter("txtIdEvento"));
        String nomeEvento = request.getParameter("txtNomeEvento");
        String descricaoEvento = request.getParameter("txtDescricaoEvento");
        String dataEvento = request.getParameter("txtDataEvento");
        String logradouroEvento = request.getParameter("txtLogradouroEvento");
        Long idTipoEvento = Long.parseLong(request.getParameter("intIdTipoEvento"));
        Long idEquipe = Long.parseLong(request.getParameter("intIdEquipe"));
        
       TipoEvento tipoEvento = TipoEventoDAO.getInstance().find(idTipoEvento);
       Equipe equipe = EquipeDAO.getInstance().find(idEquipe);
       Evento evento = new Evento (nomeEvento, descricaoEvento, dataEvento, logradouroEvento, tipoEvento, equipe);
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
