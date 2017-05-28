/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pratheesgs
 */
public class LoginService {
   public String doLogin(String email, String password){
        Connection con = null;
        String message = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","password");
            PreparedStatement statement = con.prepareStatement("SELECT EMAIL, PASSWORD FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
            statement.setString(1, email);
            statement.setString(2, password);
             
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                message = "SUCCESS";
            }else{
                message = "FAILURE";
            }
        } catch (Exception e) {
            message = "FAILURE";
            e.printStackTrace();
        }
        return message;
    }
}
