/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import dao.EventoDAO;

/**
 *
 * @author Aluno
 */
public class ManterEventoController extends HttpServlet {

   
    /** 

     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.

     * @param request servlet request

     * @param response servlet response

     * @throws ServletException if a servlet-specific error occurs

     * @throws IOException if an I/O error occurs

     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException, SQLException {

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

        } catch (IOException e) {

            throw new ServletException(e);

        } catch (SQLException e) {

            throw new ServletException(e);

        } catch (ClassNotFoundException e) {

            throw new ServletException(e);

        }

    }



    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 

     * Handles the HTTP <code>GET</code> method.

     * @param request servlet request

     * @param response servlet response

     * @throws ServletException if a servlet-specific error occurs

     * @throws IOException if an I/O error occurs

     */

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }



    /** 

     * Handles the HTTP <code>POST</code> method.

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

     * @return a String containing servlet description

     */

    @Override

    public String getServletInfo() {

        return "Short description";

    }// </editor-fold>

}
