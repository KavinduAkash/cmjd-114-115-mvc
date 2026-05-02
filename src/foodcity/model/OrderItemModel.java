/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import foodcity.db.DBConnection;
import foodcity.dto.OrderDTO;
import foodcity.dto.OrderItemDTO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author kavinduakash
 */
public class OrderItemModel {

    public boolean saveOrderItems(OrderDTO orderDto) throws SQLException {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
           
            for (OrderItemDTO orderItemDTO : orderDto.getOrderItemList()) {
             
                String sql = "INSERT INTO order_items(order_id, item_id, unit_price, qty, total_price) VALUES (" + orderDto.getOrderId() + ", " + orderItemDTO.getItemId() + ", " + orderItemDTO.getUnitPrice() + ", " + orderItemDTO.getQty() + ", " + (orderItemDTO.getUnitPrice() * orderItemDTO.getQty()) +  ")";
           
                Statement stm = conn.createStatement();

                int result = stm.executeUpdate(sql); 
                
                if(result <= 0) {
                    throw new SQLException();
                }
            }
          
        return rs;
    }            
    
}
