/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodcity.controller;

import foodcity.dto.CustomerDTO;
import foodcity.model.CustomerModel;
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
public class CustomerController {
    
    private final CustomerModel model = new CustomerModel();
    
    public boolean saveCustomer(CustomerDTO dto) {
        
        boolean result = model.saveCustomer(dto);
        return result;
        
    }
    
    public boolean updateCustomer(CustomerDTO dto) {
        
        boolean result = model.updateCustomer(dto);
        return result;
    
    }
    
    public boolean deleteCustomer(int id) {
        
        boolean result = model.deleteCustomer(id);
        return result;
        
    }
    
    public List<CustomerDTO> getCustomers() {
               
        List<CustomerDTO> result = model.getCustomers();
        return result;
        
    }
    
}
