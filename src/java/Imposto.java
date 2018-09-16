/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carol
 */
@WebServlet(urlPatterns = {"/Imposto"})
public class Imposto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            double salario = Double.parseDouble(request.getParameter("salario"));
            double salarioLiq = 0;
            double impostoRenda = 0;
            
            if (salario <= 1903.98){
                salarioLiq = salario;                
            } else if (salario >1903.98 && salario <= 2826.65){
                impostoRenda = ((salario * 0.075) - 142.80);
                salarioLiq = salario - impostoRenda;
            }else if (salario >2826.65 && salario <= 3751.05){
                impostoRenda = ((salario * 0.15) - 354.80);
                salarioLiq = salario - impostoRenda;
            }else if (salario >3751.05 && salario <= 4664.68){
                impostoRenda = ((salario * 0.225) - 636.13);
                salarioLiq = salario - impostoRenda;
            }else if (salario >4664.68){
                impostoRenda = ((salario * 0.275) - 869.36);
                salarioLiq = salario - impostoRenda;
            }
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Imposto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Salário Líquido " + salarioLiq + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
