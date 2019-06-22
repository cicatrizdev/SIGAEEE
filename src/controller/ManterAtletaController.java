package controller;

import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Long.parseLong;
import java.lang.reflect.InvocationTargetException;
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
import model.Posicao;
import utils.CRUD;

@WebServlet(name = "ManterAtletaController", urlPatterns = "/ManterAtletaController")
public class ManterAtletaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException, IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
                Long id = Long.parseLong(request.getParameter("idAtleta"));
                request.setAttribute("atleta", Atleta.find(id));
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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String operacao = request.getParameter("operacao");
        Long id = null;
        String nome = null;
        String email = null;
        String senha = null;
        String data = null;
        float altura = 0;
        float peso = 0;
        Long idEquipe = null;
        Long idPosicao = null;
        if (!operacao.equals("Incluir")) {
            id = parseLong(request.getParameter("txtIdAtleta"));
        }

        nome = request.getParameter("txtNomeAtleta");
        email = request.getParameter("txtEmailAtleta");
        senha = request.getParameter("txtSenhaAtleta");
        data = request.getParameter("txtDataNascimentoAtleta");
        altura = parseFloat(request.getParameter("txtAlturaAtleta"));
        peso = parseFloat(request.getParameter("txtPesoAtleta"));
        idEquipe = parseLong(request.getParameter("txtIdEquipe"));
        idPosicao = parseLong(request.getParameter("txtIdPosicao"));
        Equipe equipe = Equipe.find(idEquipe);
        Posicao posicao = Posicao.find(idPosicao);

        Atleta atleta = new Atleta(id, peso, altura, data, nome, email, senha, equipe, posicao);
        String metodo = CRUD.returnMethod(operacao);
        CRUD.InvokeMethod("Atleta", metodo, atleta);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
