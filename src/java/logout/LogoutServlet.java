/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logout;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pratheesgs
 */
public class LogoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	    
            HttpSession newsession = request.getSession(false);
                    if (newsession != null) 
                    {
                         newsession.invalidate();

                    }

 
                        Cookie em=new Cookie("email","");  
                        Cookie pwd=new Cookie("password","");  
                        em.setMaxAge(0); 
                        pwd.setMaxAge(0);
                        response.addCookie(em);
                        response.addCookie(pwd);
                        System.out.println("cookie Cleared");
                        response.sendRedirect("login.jsp");

    }
}
