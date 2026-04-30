/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.controller;

import foodcity.dto.ItemDTO;
import foodcity.model.ItemModel;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class ItemController {
    
    public boolean saveItem(ItemDTO dto) {
        
        ItemModel item = new ItemModel();
        boolean result = item.saveItem(dto);
        return result;
        
    }
    
    public boolean updateItem(ItemDTO dto) {
        
        ItemModel item = new ItemModel();
        boolean result = item.updateItem(dto);
        return result;
        
    }
    
    public boolean deleteItem(int id) {
        
        ItemModel item = new ItemModel();
        boolean result = item.deleteItem(id);
        return result;
        
    }
    
    public List<ItemDTO> getItems() {
        
        ItemModel item = new ItemModel();
        List<ItemDTO> result = item.getItems();
        return result;
        
    }
    
}
