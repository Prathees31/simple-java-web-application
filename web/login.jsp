<%-- 
    Document   : login
    Created on : 25 May, 2017, 2:38:29 PM
    Author     : pratheesgs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           System.out.println("welcome My Application Is Running");
        String em= null;
        String pwd=null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
	if(cookie.getName().equals("email") && cookie.getName().equals("password") ) 
            em = cookie.getValue();
            System.out.println(em);
            pwd = cookie.getValue();
            System.out.println(pwd);
            
        }
        }
  if(em != null) {response.sendRedirect("home.jsp");}
  
   %>
        <h1>Login Form</h1>
        <form action="login" method="post"> 
            UserName : <input type="email" name="email" required/>
            Password : <input type="password" name="password" required/>
            <input type="checkbox" name="rem" value="y"/> Remember Me
            <input type="submit" value="Login"/>
            
            <a href="./registration.jsp">register</a>
        </form>
        
        
    </body>
</html>
