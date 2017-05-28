package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
public class LoginServlet extends HttpServlet {
    private LoginService service = null;
   
 
    public void init(ServletConfig config) throws ServletException {
        System.out.println("initialized");
        service = new LoginService();
    }
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rem = request.getParameter("rem");
        System.out.println(rem);
        RequestDispatcher rd = null;
        if((email == null || email.isEmpty()) || (password == null || password.isEmpty())){
            rd = request.getRequestDispatcher("login.jsp");
            PrintWriter out= response.getWriter();
			out.println("<font color=red>Enter All Fields Correctly</font>");
			rd.include(request, response);
            //rd.forward(request, response);
        } 
        else {
    
            
            
            String message = service.doLogin(email, password);
            if(message.equals("SUCCESS")){
                if (rem == null){
                    
                System.out.println(rem);
                    System.out.println("cookie Fail");
                     rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
               
                    
                }
                else {
                    
            
                    System.out.println("cookie added");
                    System.out.println(rem);
                    Cookie em;
                    Cookie pwd;
                    em = new Cookie("email",email);
                    pwd = new Cookie("password",password);
                    em.setMaxAge(24 * 60 * 60);
                    pwd.setMaxAge(24 * 60 * 60);
                    response.addCookie(em); 
                    response.addCookie(pwd); 
                    rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                }
                
                
            }else if(message.equals("FAILURE")){
               rd = request.getRequestDispatcher("login.jsp");
            PrintWriter out= response.getWriter();
			out.println("<font color=red>Email or Password Incorrect</font>");
			rd.include(request, response);            }
        }
    }
}