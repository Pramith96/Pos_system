/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Orders;

/**
 *
 * @author sanuak
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Orders dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into Orders values(?,?,?)", dto.getId(), dto.getDate(), dto.getCustomerID());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete form Orders where id=?", id);
    }

    @Override
    public boolean update(Orders dto) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
