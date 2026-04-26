/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.controller;

import foodcity.dto.CustomerDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author kavinduakash
 */
public class CustomerController {
    
    public boolean saveCustomer(CustomerDTO dto) {
        
        String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
        String DB_USER = "root";
        String DB_PASSWORD = "ijsex";
        
        try {
        
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                System.out.println("Connected!!!");
                
                String sql = "INSERT INTO customers(id, name, email, address) VALUES (" + dto.getId() + ", '" + dto.getName() + "', '"+ dto.getEmail() +"', '" + dto.getAddress() + "')";
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
               
                return result > 0;
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return false;
        
    }
    
}
