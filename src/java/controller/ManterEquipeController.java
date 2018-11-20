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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);

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
                Integer idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
                request.setAttribute("equipe", Equipe.lerEquipe(idEquipe));

            }

            request.setAttribute("operacao", operacao);
            request.setAttribute("esportes", Esporte.lerTodosEsportes());
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
        int id_gestor = Integer.parseInt(request.getParameter("txtIdEquipe"));
        String logo = request.getParameter("txtLogoEquipe");
        String playbook = request.getParameter("txtPlaybookEquipe");
        int id_esporte = Integer.parseInt(request.getParameter("txtIdEsporte"));
        try {
            Equipe equipe = new Equipe(id_equipe,id_gestor, nome, logo, playbook, id_esporte);
            if (operacao.equals("Incluir")) {
                equipe.inserir();
            }else if (operacao.equals("Editar")){
                equipe.alterar();
            }else if (operacao.equals("Excluir")){
                equipe.excluir();
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
