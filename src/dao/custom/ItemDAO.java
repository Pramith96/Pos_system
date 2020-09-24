/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import dao.CrudDAO;
import java.sql.SQLException;
import entity.Item;

/**
 *
 * @author sanuak
 */
public interface ItemDAO extends CrudDAO<Item, String>{
    public String getLastItemID()throws SQLException,ClassNotFoundException;
}
