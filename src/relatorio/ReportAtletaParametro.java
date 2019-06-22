//package relatorio;
//
//import dao.BD;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//
///**
// *
// * @author PeeP
// */
//public class ReportAtletaParametro extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        Connection conexao = null;
//        try {
//            conexao = BD.getConexao();
//            HashMap parametros = new HashMap();
//            parametros.put("PAR_Nome", request.getParameter("paramAtleta"));
//            String relatorio = getServletContext().getRealPath("/WEB-INF/classes/relatorio") + "/ReportAtletaParam.jasper";
//            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
//            byte[] relat = JasperExportManager.exportReportToPdf(jp);
//            response.setHeader("Content-Disposition", "attachment;filename=relatorioAdministradorLP3.pdf");
//            response.setContentType("application/pdf");
//            response.getOutputStream().write(relat);
//
//        } catch (ClassNotFoundException |JRException| IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (!conexao.isClosed()) {
//                    conexao.close();
//                }
//            } catch (SQLException ex) {
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(ReportAtletaParametro.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(ReportAtletaParametro.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//}