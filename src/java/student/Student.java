/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author pratheesgs
 */
public class Student {
            private int rollno;
            private String name;
            private String department;
            private String section;
            private String fname;
            private String address;
            private String mobile;
                    public int getRollNo() {
                           return rollno;
                   }

                   public String getName() {
                           return name;
                   }

                   public String getDepartment() {
                           return department;
                   }

                   public String getSection() {
                           return section;
                   }
                   public String getFname() {
                           return fname;
                   }
                   public String getAddress() {
                           return address;
                   }
                   public String getMobile() {
                           return mobile;
                   }
                   public void setRollNo(int rollno) {
                           this.rollno   = rollno;
                   }

                   public void setName(String name) {
                           this.name = name;
                   }

                   public void setDepartment(String department) {
                           this.department = department;
                   }

                   public void setSection(String section) {
                           this.section = section;
                   }
                   public void setFname(String fname) {
                           this.fname = fname;
                   }
                   public void setAddress(String address) {
                           this.address = address;
                   }
                   public void setMobile(String mobile) {
                           this.mobile = mobile;
                   }    
}
