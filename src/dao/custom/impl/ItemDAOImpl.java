/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Item;

/**
 *
 * @author sanuak
 */
public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean add(Item dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("Insert into Item values(?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice());
    }

    @Override
    public boolean delete(String code) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Delete from Item where code=?", code);
    }

    @Override
    public boolean update(Item dto) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Item set description=?,qtyOnHand=?,unitPrice=? where code=?", dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice(), dto.getCode());
    }

    @Override
    public Item search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Item where code=?", code);
        Item enty = null;
        while (rst.next()) {
            enty = new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        }
        return enty;
    }

    @Override
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return allItems;
    }

    @Override
    public String getLastItemID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
