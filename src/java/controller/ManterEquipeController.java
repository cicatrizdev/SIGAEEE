package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.Equipe;
import model.Esporte;

public class ManterEquipeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setAttribute("equipes", Equipe.lerTodasEquipes());
            RequestDispatcher view = request.getRequestDispatcher("/cadastroEquipe.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", "operacao");
            request.setAttribute("atletas", Equipe.lerTodasEquipes());
            RequestDispatcher view = request.getRequestDispatcher("/cadastroEquipe.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        int id_equipe = Integer.parseInt(request.getParameter("txtIdEquipe"));
        String nome = request.getParameter("txtNomeEquipe");
        String logo = request.getParameter("txtLogoEquipe");
        String playbook = request.getParameter("txtPlaybookEquipe");
        Esporte esporte = new Esporte(Integer.parseInt(request.getParameter("optIdEsporte")), request.getParameter("optEsporte"));

        try {
            /*            Equipe equipe = null;
            if (esporte != 0){
                equipe= Equipe.esporte.getIdEsporte();
            }
             */
            Equipe equipe = new Equipe(id_equipe, nome, logo, playbook, esporte);
            if (operacao.equals("Incluir")) {
                equipe.inserir();
            }
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
       // processRequest(request, response);
             String acao = request.getParameter("acao");
             if (acao.equals("prepararOperacao")){
            try {
                prepararOperacao(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
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
        processRequest(request, response);
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
