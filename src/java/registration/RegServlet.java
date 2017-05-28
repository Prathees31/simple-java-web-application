/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

/**
 *
 * @author pratheesgs
 */
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registration.RegService;

/**
 *
 * @author pratheesgs
 */
public class RegServlet extends HttpServlet {
    private RegService service = null;
   
 
    public void init(ServletConfig config) throws ServletException {
        System.out.println("initialized");
        service = new RegService();
    }
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
        if((email == null || email.isEmpty()) || (password == null || password.isEmpty())){
            rd = request.getRequestDispatcher("registration.jsp");
            PrintWriter out= response.getWriter();
			out.println("<font color=red>Enter All Fields</font>");
			rd.include(request, response);
        }else{
            String message = service.doReg(email, password);
            if(message.equals("SUCCESS")){
               rd = request.getRequestDispatcher("registration.jsp");
            PrintWriter out= response.getWriter();
			out.println("<font color=red>Already registerd email</font>");
			rd.include(request, response);
//                rd = request.getRequestDispatcher("success_1.jsp");
//                rd.forward(request, response);
            }else if(message.equals("FAILURE")){
                rd = request.getRequestDispatcher("failure_1.jsp");
                rd.forward(request, response);
            }
        }
    }
}