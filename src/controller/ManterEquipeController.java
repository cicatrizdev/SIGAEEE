package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.Equipe;
import model.Esporte;
import model.Gestor;
import utils.CRUD;

public class ManterEquipeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {
            try {
                confirmarOperacao(request, response);
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            if (!operacao.equals("Incluir")) {
                Long id = Long.parseLong(request.getParameter("idEquipe"));
                request.setAttribute("equipe", Equipe.find(id));
            }

            request.setAttribute("operacao", operacao);
            request.setAttribute("esportes", Esporte.findAll());
            request.setAttribute("gestores", Gestor.findAll());
            RequestDispatcher view = request.getRequestDispatcher("/cadastroEquipe.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String operacao = request.getParameter("operacao");
        Long idGestor = Long.parseLong(request.getParameter("txtIdGestor"));
        Long idEsporte = Long.parseLong(request.getParameter("txtIdEsporte"));
        Long id = null;
        String nome = null;
        String logo = null;
        String playbook = null;
        Gestor gestor = null;
        Esporte esporte = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("txtIdEquipe"));
            System.out.println(id);
        }
        nome = request.getParameter("txtNomeEquipe");
        logo = request.getParameter("txtLogoEquipe");
        playbook = request.getParameter("txtPlaybookEquipe");
        gestor = Gestor.find(idGestor);
        esporte = Esporte.find(idEsporte);
        try {
            Equipe equipe = new Equipe(id, nome, logo, playbook, gestor, esporte);
            System.out.println("Id Equipe" + equipe.getIdEquipe());
            String metodo = CRUD.returnMethod(operacao);
            CRUD.InvokeMethod("Equipe", metodo, equipe);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEquipeController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
