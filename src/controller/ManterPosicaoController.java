/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Esporte;
import model.Posicao;

public class ManterPosicaoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
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
                Long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("posicao", Posicao.find(id));

            }

            request.setAttribute("operacao", operacao);
            request.setAttribute("esportes", Esporte.findAll());
            RequestDispatcher view = request.getRequestDispatcher("/cadastroPosicao.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if (!operacao.equals("Incluir")) {
            Long id = Long.parseLong(request.getParameter("txtIdPosicao"));
        }
        Long esporte = Long.parseLong(request.getParameter("txtIdEsporte"));
        System.out.println("id - " + esporte);
        String nome = request.getParameter("txtNomePosicao");
        Posicao posicao = new Posicao(esporte, nome);
        try {
            
            System.out.println("idEsporte: " + posicao.getIdPosicao());
            switch (operacao) {
                case "Incluir":
                    posicao.save();
                    break;
                case "Editar":
                    posicao.save();
                    break;
                case "Excluir":
                    posicao.remove();
                    break;
                default:
                    break;
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPosicaoController");
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
            Logger.getLogger(ManterEsporteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEsporteController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterEsporteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEsporteController.class.getName()).log(Level.SEVERE, null, ex);
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
