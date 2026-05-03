/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.dto;

import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderDTO {
    private int orderId;
    private int customerId;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(int customerId, List<OrderItemDTO> items) {
        this.customerId = customerId;
        this.items = items;
    }
   
    public OrderDTO(int orderId, int customerId, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", customerId=" + customerId + ", items=" + items + '}';
    }
}
