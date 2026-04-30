/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import foodcity.dto.ItemDTO;
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
public class ItemModel {
    public boolean saveItem(ItemDTO dto) {
        String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
        String DB_USER = "root";
        String DB_PASSWORD = "ijse";
        
        boolean rs = false;
        
        try {
        
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                
                String sql = "INSERT INTO items(id, name, qty, unit_price) VALUES (" + dto.getId() + ", '" + dto.getName() + "', "+ dto.getQty() +", " + dto.getPrice() + ")";
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return rs;
    }
    
    public boolean updateItem(ItemDTO dto) {
        String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
        String DB_USER = "root";
        String DB_PASSWORD = "ijse";
        
        boolean rs = false;
        
        try {
        
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                String sql = "UPDATE items SET name='" + dto.getName() + "', qty=" + dto.getQty() + ", unit_price='" + dto.getPrice() + "' WHERE id=" + dto.getId();
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return rs;
    }
    
    public boolean deleteItem(int id) {
         String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
        String DB_USER = "root";
        String DB_PASSWORD = "ijse";
        
        boolean rs = false;
        
        try {
        
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                String sql = "DELETE FROM items WHERE id=" + id;
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return rs;
    }
    
    public List<ItemDTO> getItems() {
        String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
        String DB_USER = "root";
        String DB_PASSWORD = "ijse";
        
        List<ItemDTO> dtos = new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM items";
                
                Statement stm = conn.createStatement();
                
                ResultSet result = stm.executeQuery(sql);
            
                while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    int qty = result.getInt("qty");
                    double price = result.getDouble("unit_price");
                    
                    ItemDTO dto = new ItemDTO(id, name, qty, price);
                    dtos.add(dto);
                }
                
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
        }
        
        return dtos;
    }
}
