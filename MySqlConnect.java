/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KULLANICI-PC
 */
import java.sql.*;
import javax.swing.*;

public class MySqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
    try{
    Class.forName("com.sql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/pharmacistlogin","root","Mstf0411!!");
    JOptionPane.showMessageDialog(null,"connecting to database");
    return conn;
}
catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
}
}
}
