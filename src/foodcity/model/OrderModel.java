/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import foodcity.db.DBConnection;
import foodcity.dto.OrderDTO;

/**
 *
 * @author kavinduakash
 */
public class OrderModel {
    
    private final OrderItemModel orderItemModel = new OrderItemModel();
    
    public boolean placeOrder(OrderDTO orderDTO) throws Exception {
    
        boolean rs = false;
        
        Connection conn = DBConnection.getInstance().getConnection();
        
        
        conn.setAutoCommit(false);
        
        try {
            String sql = "INSERT INTO orders(customer_id) VALUES (" + orderDTO.getCustomerId() + ")";

            Statement stm = conn.createStatement();

            int result1 = stm.executeUpdate(sql);

            if(result1 > 0) {

                sql = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
                ResultSet result2 = stm.executeQuery(sql);

                while(result2.next()) {
                    int orderId = result2.getInt("id");
                    orderDTO.setOrderId(orderId);
                    rs = orderItemModel.saveOrderItems(orderDTO);
                }

            }
            
            conn.commit();
            
        } catch(Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return rs;
        
    }
    
}
