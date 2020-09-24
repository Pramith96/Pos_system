/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.CustomerDTO;
import entity.Customer;

/**
 *
 * @author sanuak
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("Insert into Customer values(?,?,?,?)", dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("Delete from Customer where id=?", id);
    }

    @Override
    public boolean update(Customer dto) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Customer set name=?,address=?,salary=? where id=?", dto.getName(), dto.getAddress(), dto.getSalary(), dto.getId());
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from Customer where id=?", id);
        Customer enty = null;
        while (rst.next()) {
            enty = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return enty;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
        }
        return allCustomers;
    }

    @Override
    public String getCustomerLastID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
