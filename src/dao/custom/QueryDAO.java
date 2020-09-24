/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.CustomEntity;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public interface QueryDAO extends SuperDAO{
          public ArrayList<CustomEntity> getCustomersOrdersByID(String id)throws SQLException,ClassNotFoundException;
}
