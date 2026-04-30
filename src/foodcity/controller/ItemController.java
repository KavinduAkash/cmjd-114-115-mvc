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
    
    private final ItemModel item = new ItemModel();
    
    public boolean saveItem(ItemDTO dto) {
        
        boolean result = item.saveItem(dto);
        return result;
        
    }
    
    public boolean updateItem(ItemDTO dto) {
       
        boolean result = item.updateItem(dto);
        return result;
        
    }
    
    public boolean deleteItem(int id) {
        
        boolean result = item.deleteItem(id);
        return result;
        
    }
    
    public List<ItemDTO> getItems() {
        
        List<ItemDTO> result = item.getItems();
        return result;
        
    }
    
    public ItemDTO getItemDetails(int id) {
        
        ItemDTO result = item.getItemDetails(id);
        return result;
        
    }
    
}
