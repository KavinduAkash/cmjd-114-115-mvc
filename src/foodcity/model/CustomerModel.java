/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import foodcity.db.DBConnection;
import foodcity.dto.CustomerDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class CustomerModel {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "ijse";
    
    public boolean saveCustomer(CustomerDTO dto) {
       
        
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            
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
    
    public boolean updateCustomer(CustomerDTO dto) {
        boolean rs = false;
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                System.out.println("Connected!!!");
                
                String sql = "UPDATE customers SET name='" + dto.getName() + "', email='" + dto.getEmail() + "', address='" + dto.getAddress() + "' WHERE id=" + dto.getId();
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return rs;
    }
    
    public boolean deleteCustomer(int id) {
        boolean rs = false;
        
        try {
        
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                System.out.println("Connected!!!");
                
                String sql = "DELETE FROM customers WHERE id=" + id;
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
                
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return rs;
    }
    
    public List<CustomerDTO> getCustomers() {
        List<CustomerDTO> dtos = new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM customers";
                
                Statement stm = conn.createStatement();
                
                ResultSet result = stm.executeQuery(sql);
            
                while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String email = result.getString("email");
                    String address = result.getString("address");
                    
                    CustomerDTO dto = new CustomerDTO(id, name, email, address);
                    dtos.add(dto);
                }
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return dtos;
    }
    
}
