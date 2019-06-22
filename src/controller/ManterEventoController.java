package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import utils.CRUD;

public class ManterEventoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
            request.setAttribute("tiposEvento", TipoEvento.findAll());
            request.setAttribute("equipes", Equipe.findAll());
            if (!operacao.equals("Incluir")) {
                Long id = Long.parseLong(request.getParameter("idEvento"));
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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String operacao = request.getParameter("operacao");
        Long id = null;
        String nome = null;
        String descricao = null;
        String data = null;
        String logradouro = null;
        Long idTipoEvento = Long.parseLong(request.getParameter("intIdTipoEvento"));
        Long idEquipe = Long.parseLong(request.getParameter("intIdEquipe"));
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("txtIdEvento"));

        }
        nome = request.getParameter("txtNomeEvento");
        descricao = request.getParameter("txtDescricaoEvento");
        data = request.getParameter("txtDataEvento");
        logradouro = request.getParameter("txtLocalEvento");
        TipoEvento tipoEvento = TipoEvento.find(idTipoEvento);
        Equipe equipe = Equipe.find(idEquipe);

        Evento evento = new Evento(id, nome, descricao, data, logradouro, tipoEvento, equipe);
        String metodo = CRUD.returnMethod(operacao);

        CRUD.InvokeMethod("Evento", metodo, evento);
        RequestDispatcher view = request.getRequestDispatcher("PesquisaEventoController");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                try {
                    processRequest(request, response);
                } catch (IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchMethodException | IllegalAccessException ex) {
                Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                try {
                    processRequest(request, response);
                } catch (IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchMethodException | IllegalAccessException ex) {
                Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";

    }
}
