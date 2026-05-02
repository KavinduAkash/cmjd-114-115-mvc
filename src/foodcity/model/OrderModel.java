/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import java.sql.Connection;
import foodcity.db.DBConnection;
import foodcity.dto.OrderDTO;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kavinduakash
 */
public class OrderModel {
    
    private final OrderItemModel orderItemModel = new OrderItemModel();
    
    public boolean saveOrder(OrderDTO order) throws SQLException {
        Connection conn = null;
        boolean rs = false;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
           
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO orders(customer_id) VALUES (" + order.getCustomerId() + ")";
           
            Statement stm = conn.createStatement();
                
            int result1 = stm.executeUpdate(sql);
                
            if(result1 > 0) {
                sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
                ResultSet result2 = stm.executeQuery(sql);

                while(result2.next()) {
                    int orderId = result2.getInt("id");
                    order.setOrderId(orderId);
                    rs = orderItemModel.saveOrderItems(order);
                    if(rs) {
                        conn.commit();
                    }
                }
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong!!!");
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return rs;
        
    }
}
