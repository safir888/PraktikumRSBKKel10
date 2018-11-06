/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitungkalori.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kalori.ejb.HitungKaloriBeanLocal;
/**
 *
 * @author User ID
 */
@WebServlet(name = "HitungKalori", urlPatterns = {"/HitungKalori"})
public class HitungKalori extends HttpServlet {

    @EJB
    private HitungKaloriBeanLocal hitungKaloriBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request,
    HttpServletResponse response) throws ServletException,IOException {
        double n1 = 0.0;
            if(request.getParameter("n1") != null) {
            n1 = Double.parseDouble(request.getParameter("n1"));
        }
        double n2 = 0.0;
            if(request.getParameter("n2") != null) {
            n2 = Double.parseDouble(request.getParameter("n2"));
        }
        int n3 = 0;
            if(request.getParameter("n3") != null) {
            n3 = Integer.parseInt(request.getParameter("n3"));
        }
            //DecimalFormat a = new DecimalFormat("0.0");
        String operation = request.getParameter("op");
        String value = "";
        
        
        if(operation != null && operation.equals("kaloriPria")) {
        value += hitungKaloriBean.kaloriPria(n1, n2, n3);
        }
        if(operation != null && operation.equals("kaloriWanita")) {
        value += hitungKaloriBean.kaloriWanita(n1, n2, n3);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    try {
        out.println("<center>");
        out.println("<title>Hitung Kalori Harian</title>");
        out.println("<form method=\"post\" action=\"HitungKalori\">");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a> Berat (kg)</a>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<input type=\"text\" name=\"n1\" value=\"" + n1 + "\"/ placeholder=\"Berat\">");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a> Tinggi (cm)</a>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<input type=\"text\" name=\"n2\" value=\"" + n2 + "\"/ placeholder=\"Tinggi\">");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a> Umur </a>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<input type=\"text\" name=\"n3\" value=\"" + n3 + "\"/ placeholder=\"Umur\">");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<select name=\"op\">");
        out.println("<option value=\"kaloriPria\">Pria</option>");
        out.println("<option value=\"kaloriWanita\">Wanita</option>");
        out.println("</select>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<input type=\"submit\" value=\"Hitung Kalori\" />");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<input type=\"text\" name =\"result\" value=\"" +  value + "\" />");
        out.println("</form>");
        out.println("</center>");
    }
    catch (Exception ex) {
    out.println("Error:"+
    ex.getMessage());
    }
    finally {
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    out.close();
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
        processRequest(request, response);
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
