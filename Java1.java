// execution part
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_odbc_connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author imtiaz
 */
public class Java1 extends JFrame{

    /**
     * @param args the command line arguments
     */
        JTable table;
    
    public Java1(Object[][] data){
        setLayout(new FlowLayout());
        
        String[] columnNames = {"EMPLOYEENAME","NID","SALARY"};

        table = new JTable(data,columnNames);     
        table.setPreferredScrollableViewportSize(new Dimension(400,100));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    
    

    // table forming 
    public static void main(String[] args) {
        // TODO code application logic here
        Connection test = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[][] data= new Object[5][3];
        
        
        
      // catching connection from OracleConnection
        try{
            
            test = OracleConnection.getConnect();
            //Query
            String sql = "select * from PAIDEMPLOYEE";
            //
            ps = test.prepareStatement(sql);
            //
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){ 
                
                for(int j = 0; j<3; j++)
                {
                    data[i][j] = rs.getString(j+1);
                }
                i++;
               
            }
            }
        catch(Exception e){
                System.out.print(e);
            }
        Java1 gui = new Java1(data);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600, 200);
        gui.setVisible(true);
        gui.setTitle("Paid Employee Table");
        
        

    }
}


