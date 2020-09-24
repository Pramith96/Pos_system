/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> getCustomersOrdersByID(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select Orders.id,"
                + "Orders.date,"
                + "Orders.customerID,"
                + "OrderDetail.orderId,"
                + "OrderDetail.itemCode,"
                + "OrderDetail.qty,"
                + "OrderDetail.unitPrice"
                + " from Orders inner join OrderDetail"
                + " on Orders.id=OrderDetail.orderId"
                + " where Orders.customerID=?", id);
        ArrayList<CustomEntity> allDetails = new ArrayList<>();
        while (rst.next()) {
            allDetails.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6), rst.getDouble(7)));
        }
        return allDetails;
    }

    

}
