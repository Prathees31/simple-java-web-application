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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pratheesgs
 */
public class RegService {
   public String doReg(String email, String password){
        Connection con = null;
        String message = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","password");
            System.out.println("connected");
            PreparedStatement statement = con.prepareStatement("SELECT  EMAIL  FROM USER WHERE EMAIL = ? ");
           
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
             System.out.println("select excuted");
//            System.out.println(rs. );
            if(rs.first()){
                message = "SUCCESS";
                 System.out.println("select sucess");
            }else{
                message = "FAILURE";
                 System.out.println("select faail");
                 PreparedStatement statequery = con.prepareStatement("INSERT INTO USER (EMAIL,PASSWORD) VALUES (?,?)");
                 statequery.setString(1, email);
                 statequery.setString(2,password);
                 
                 int insert;
                insert = statequery.executeUpdate();
                System.out.println("insert excuted");
                if (insert > 0) {
                    System.out.println("Insert Sucess");
                }else {
                    System.out.println("Fail");
                }
            }
        } catch (Exception e) {
            message = "FAILURE";
            e.printStackTrace();
        }
        return message;
    }
}
