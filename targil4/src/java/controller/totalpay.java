/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.dbclass;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mod.Beanclass;
import mod.helper;
import mod.student;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "totalpay", urlPatterns = {"/totalpay"})
public class totalpay extends HttpServlet {

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
            helper h=new helper();
        String error="";
        String nextpage="";
        try{
           String number =request.getParameter("number");
            if (h.isNullOrEmpty(number)&& Integer.parseInt(number)<0) {
                error += "number is empty or not good.<br/>";
              }
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","paymentstudent.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
           Beanclass s=(Beanclass)request.getSession().getAttribute("bean");
            System.out.println(s.getStrudent().getFirstname()); 
            if( Integer.parseInt(number)<s.getStrudent().getPenalty()){
            DB.dbclass db=new dbclass();
          int c= db.updatepanstudent(s.getStrudent().getId(),(s.getStrudent().getPenalty()-(Integer.parseInt(number))));
           if(c==0){
                nextpage="/erroradd.jsp" ;
                error="Payment failed";
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","paymentstudent.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response);  
           }
              nextpage="/ssuccess.jsp";
             String success="Details successfully added";
             request.getSession().setAttribute("success",success);
              request.getRequestDispatcher(nextpage).forward(request, response);
        }
                nextpage="/erroradd.jsp" ;
                error="Payment failed";
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","paymentstudent.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
        }
        catch(Exception e){
            
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
