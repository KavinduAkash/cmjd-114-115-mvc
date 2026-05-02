/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.controller;

import foodcity.dto.OrderDTO;
import foodcity.model.OrderModel;

/**
 *
 * @author kavinduakash
 */
public class OrderController {
    
    private final OrderModel orderModel = new OrderModel();
    
    public boolean placeOrder(OrderDTO order) throws Exception {
        
        boolean result = orderModel.saveOrder(order);
        return result;
        
    }
    
}
