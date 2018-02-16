package Code;

import com.sun.istack.internal.FinalArrayList;
import java.sql.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PT
 */
public class Employee {
    private String empName;
    
    public Employee() {
        this(null);
    }

    public Employee(String empName) {
        this.empName = empName;
        try{
            addEmp();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public void addEmp() throws ClassNotFoundException, SQLException{
        String sql = "insert into Employee(empName, Username, Password) values('"+getEmpName()+")";
        Connection con = ConnectionBuilder.connect();
        Statement st = con.createStatement();
        System.out.println("123");
        st.executeUpdate(sql);
        System.out.println("123");
        st.close();
        con.close();
        System.out.println("This Employee Add to Database");
    }
     
    public static ArrayList<Employee> execute(String sql) throws SQLException, ClassNotFoundException{
        Connection con = ConnectionBuilder.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from EMPLOYEE");
        
        ArrayList<Employee> all = new FinalArrayList<>();
        while(rs.next()){
            System.out.print(rs.getString("empid")+"\n"+rs.getString("empname")+"\n"+rs.getString("username")+"\n"+rs.getString("password")+"\n");
        }
        con.close();
        return all;
    }

    @Override
    public String toString() {
        return "empName=" + empName ;
    }
    
    
}
