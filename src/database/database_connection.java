/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author zeeshan ahmad
 */
public class database_connection {
    public  static Connection c;
     public  static Statement st;
     public static PreparedStatement i_list,search,b_register,b_search ,r_info;
    
     static{
         try{
     
         Class.forName("oracle.jdbc.driver.OracleDriver");
         c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","my_library","oracle");
         st=c.createStatement();
         i_list=c.prepareStatement("insert into issue_list(name,roll,course,branch,year,section,book,author,idate,rdate) values(?,?,?,?,?,?,?,?,?,?)");
         search=c.prepareStatement("select * from issue_list where name like ?");
         b_register=c.prepareStatement("insert into book_list(name,publication,author,quantity)values(?,?,?,?)");
         b_search=c.prepareStatement("select * from book_list where name like ?");
         r_info=c.prepareStatement("insert into return_info(roll,returndate,returneddate,fine)values(?,?,?,?)");
         
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
         
    
}
}
