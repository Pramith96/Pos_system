/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public interface CrudDAO<T,ID> extends SuperDAO{
     public boolean add(T dto) throws SQLException, ClassNotFoundException ;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException ;
    public boolean update(T dto) throws ClassNotFoundException, SQLException ;
    public  T search(ID id) throws SQLException, ClassNotFoundException ;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;
  
}
