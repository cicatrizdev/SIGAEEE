package controller;

import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atleta;
import model.Equipe;
import model.Gestor;
import model.Posicao;

@WebServlet(name = "ManterAtletaController", urlPatterns = "/ManterAtletaController")
public class ManterAtletaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException, IOException {
        String acao = request.getParameter("acao");
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("acao", acao);
        System.out.println("AQUI");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
        System.out.println("AQUI2");
            prepararOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                Long id = Long.parseLong(request.getParameter("id"));
                Atleta atleta = Atleta.find(Long.parseLong(request.getParameter("id")));
                request.setAttribute("atleta", atleta);
            }
            request.setAttribute("posicoes", Posicao.findAll());
            request.setAttribute("equipes", Equipe.findAll());
            RequestDispatcher view = request.getRequestDispatcher("/cadastroAtleta.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("txtNomeAtleta");
        if (!operacao.equals("Incluir")) {
            Long id = parseLong(request.getParameter("txtIdAtleta"));
            Long equipe = parseLong(request.getParameter("intIdEquipe"));
            Long posicao = parseLong(request.getParameter("intIdPosicao"));
        }
        String email = request.getParameter("txtEmailAtleta");
        String senha = request.getParameter("txtSenhaAtleta");
        String data = request.getParameter("txtDataNascimentoAtleta");
        float altura = parseFloat(request.getParameter("txtAlturaAtleta"));
        float peso = parseFloat(request.getParameter("txtPesoAtleta"));
        Atleta atleta = new Atleta(peso, altura, data, nome, email, senha);
        switch (operacao) {
            case "Incluir":
                atleta.save();
                break;
            case "Editar":
                atleta.save();
                break;
            case "Excluir":
                System.out.println("Excluir"+atleta.getIdUsuario());
                atleta.remove();
                break;
            default:
                break;
        }
        request.getRequestDispatcher("PesquisaAtletaController").forward(request, response);
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
