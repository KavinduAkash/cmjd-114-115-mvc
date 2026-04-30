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
    
    public boolean saveCustomer(CustomerDTO dto) {
        
        CustomerModel model = new CustomerModel();
        boolean result = model.saveCustomer(dto);
        return result;
        
    }
    
    public boolean updateCustomer(CustomerDTO dto) {
        
        CustomerModel model = new CustomerModel();
        boolean result = model.updateCustomer(dto);
        return result;
    
    }
    
    public boolean deleteCustomer(int id) {
        
        CustomerModel model = new CustomerModel();
        boolean result = model.deleteCustomer(id);
        return result;
        
    }
    
    public List<CustomerDTO> getCustomers() {
        
        CustomerModel model = new CustomerModel();
        List<CustomerDTO> result = model.getCustomers();
        return result;
        
    }
    
}
