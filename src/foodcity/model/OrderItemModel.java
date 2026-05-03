/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.model;

import java.sql.Connection;
import java.sql.Statement;
import foodcity.db.DBConnection;
import foodcity.dto.OrderDTO;
import foodcity.dto.OrderItemDTO;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderItemModel {
    
    public boolean saveOrderItems(OrderDTO orderDTO) throws Exception {
        
        Connection conn = DBConnection.getInstance().getConnection();
        
        for (OrderItemDTO item : orderDTO.getItems()) {
            String sql = "INSERT INTO order_items(order_id, item_id, unit_price, qty, total_price) VALUES (" + orderDTO.getOrderId() + ", " + item.getItemId() + ", " + item.getUnitPrice() + ", " + item.getQty() + ", " + item.getUnitPrice()*item.getQty() + ")";
            Statement stm = conn.createStatement();
            int result = stm.executeUpdate(sql);
            
            // change item qty
        }
        
        return true;
    }
    
}
