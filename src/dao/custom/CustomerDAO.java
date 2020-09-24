/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import dao.CrudDAO;
import java.sql.SQLException;
import entity.Customer;

/**
 *
 * @author sanuak
 */
public interface CustomerDAO extends CrudDAO<Customer, String>{
    public String getCustomerLastID()throws SQLException,ClassNotFoundException;

}
