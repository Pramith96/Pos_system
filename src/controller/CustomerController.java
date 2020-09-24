/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.custom.impl.CustomerDAOImpl;
import dao.CrudDAO;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.CustomerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.CustomerDTO;
import entity.Customer;

/**
 *
 * @author sanu-vithanage
 */
public class CustomerController {

    static CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public static boolean addCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException, Exception {
        return dao.add(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
    }

    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return dao.delete(id);
    }

    public static boolean updateCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException, Exception {
        return dao.update(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
    }

    public static CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        Customer enty = dao.search(id);
        return new CustomerDTO(enty.getId(), enty.getName(), enty.getAddress(), enty.getSalary());
    }

    public static ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer enty : all) {
            allCustomers.add(new CustomerDTO(enty.getId(), enty.getName(), enty.getAddress(), enty.getSalary()));
        }
        return allCustomers;
    }

}
