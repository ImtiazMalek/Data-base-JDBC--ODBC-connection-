//connection part
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_odbc_connection;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author imtiaz
 */



public class OracleConnection {
    
    public static Connection getConnect(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","IMTIAZWORK1","94imti");
            return conn;
            }
        catch(Exception e){
        
            System.out.print(e);
        }
    
    
    return null;
    
    }
    
    
    
    
    
}