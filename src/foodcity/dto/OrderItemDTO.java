/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.dto;

/**
 *
 * @author kavinduakash
 */
public class OrderItemDTO {
    
    private int orderItemId;
    private int itemId;
    private int qty;
    private double unitPrice;

    public OrderItemDTO() {
    }

    public OrderItemDTO(int itemId, int qty, double unitPrice) {
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderItemDTO(int orderItemId, int itemId, int qty, double unitPrice) {
        this.orderItemId = orderItemId;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" + "orderItemId=" + orderItemId + ", itemId=" + itemId + ", qty=" + qty + ", unitPrice=" + unitPrice + '}';
    }
    
}
