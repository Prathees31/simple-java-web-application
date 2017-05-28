/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pratheesgs
 */
public class StudentService {
    
   
   public void addStudent(Student student) {
                    Connection con = null;
	String message = null;
	try {
                                     Class.forName("com.mysql.jdbc.Driver");
                                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
                                     PreparedStatement pStmt = con.prepareStatement( "INSERT INTO STUDENT(ROLLNO, NAME, DEPARTMENT,SECTION,FNAME,ADDRESS,MOBILE ) VALUES (?,?,?,?,?,?,?)");
		pStmt.setInt(1, student.getRollNo());
		pStmt.setString(2, student.getName());
		pStmt.setString(3, student.getDepartment());
		pStmt.setString(4, student.getSection());
                                         pStmt.setString(5, student.getFname());
                                          pStmt.setString(6, student.getAddress());
                                           pStmt.setString(7, student.getMobile());
		        int rs = pStmt.executeUpdate();
                                        if(rs>0){
                                message = "SUCCESS";
                                }else{
                                message = "FAILURE";
                                 }
	} catch (Exception e) {
                       message = "FAILURE";
                       System.out.println(message);
                       System.err.println(e.getMessage());
                       e.printStackTrace();
                   
        }
      
}

public void deleteStudent(int rollno) {
                    Connection con = null;
	String message = null;
	
	try {
                                     Class.forName("com.mysql.jdbc.Driver");
                                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
                                     PreparedStatement pStmt = con.prepareStatement( "DELETE FROM STUDENT WHERE ROLLNO = ?");
		pStmt.setInt(1, rollno);
		int rs = pStmt.executeUpdate();
                                        if(rs>0){
                                message = "SUCCESS";
                                }else{
                                message = "FAILURE";
                                 }
	} catch (Exception e) {
                       message = "FAILURE";
                       System.out.println(message);
                       System.err.println(e.getMessage());
                       e.printStackTrace();
                   
        }
}

public void updateStudent(Student student)  {
                    Connection con = null;
	String message = null;
	
	try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
                                          PreparedStatement pStmt = con.prepareStatement("UPDATE STUDENT SET NAME = ?, DEPARTMENT = ?, SECTION = ? FNAME=?, ADDRESS=?,MOBILE=? WHERE ROLLNO = ?" );
			
		pStmt.setString(1, student.getName());
		pStmt.setString(2, student.getDepartment());
		pStmt.setString(3, student.getSection());
                                        pStmt.setString(4, student.getFname());
                                        pStmt.setString(5, student.getAddress());
                                        pStmt.setString(6, student.getMobile());
		pStmt.setInt(7, student.getRollNo());
		int rs = pStmt.executeUpdate();
                                        if(rs>0){
                                message = "SUCCESS";
                                }else{
                                message = "FAILURE";
                                 }
	} catch (Exception e) {
                       message = "FAILURE";
                       System.out.println(message);
                       System.err.println(e.getMessage());
                       e.printStackTrace();
                   
        }
}

public List<Student> getAllStudents() {
	List<Student> students = new ArrayList<Student>();
                    Connection con = null;
	String message = null;
	String query = "SELECT * FROM STUDENT ORDER BY ROLLNO";
	try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
		 Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Student student = new Student();

			student.setRollNo(rs.getInt("ROLLNO"));
			student.setName(rs.getString("NAME"));
			student.setDepartment(rs.getString("DEPARTMENT"));
			student.setSection(rs.getString("SECTION"));
                                                            student.setFname(rs.getString("FNAME"));
                                                            student.setAddress(rs.getString("ADDRESS"));
                                                            student.setMobile(rs.getString("MOBILE"));
			students.add(student);
		}
	}catch (Exception e) {
                       message = "FAILURE";
                       System.out.println(message);
                       System.err.println(e.getMessage());
                       e.printStackTrace();
                   
        }
	return students;
}
}
